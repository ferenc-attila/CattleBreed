package service.read.fromcsv;

import breed.Breed;
import breed.cattle.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class ReadHerdFromCsv {

    public Breed readCsvAsBreed(Path path) {
        List<String> fileContent = readCsv(path);
        fileContent.remove(0);
        Breed breed = new Breed();
        int count = 2;
        try {
            for (String actual : fileContent) {
                String[] row = actual.split(",");
                CattleProperties properties = parseCattleProperties(row);
                CattleRegistration registration = new CattleRegistration(Integer.parseInt(row[0]), "", LocalDate.parse(row[2]), CauseOfIncoming.REPRODUCTION, LocalDate.parse(row[5]));
                Cattle cattle = new Cattle(row[1], LocalDate.parse(row[2]), properties, registration);
                breed.addCattle(cattle);
                count++;
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid number in csv row number " + count);
        }
        return breed;
    }

    private List<String> readCsv(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("No such file!");
        }
    }

    private CattleProperties parseCattleProperties(String[] row) {
        if (row.length == 8) {
            return new CattleProperties(row[6], "", "", row[3], row[4], new Parents(row[6], row[7]), "");
        } else {
            return new CattleProperties(row[6], "", "", row[3], row[4], new Parents(row[6]), "");
        }
    }
}

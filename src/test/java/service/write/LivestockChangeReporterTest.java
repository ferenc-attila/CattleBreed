package service.write;

import breed.Breed;
import org.junit.jupiter.api.Test;
import service.read.fromcsv.ReadHerdFromCsv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LivestockChangeReporterTest {

    @Test
    void createTest() {
        LivestockChangeReporter livestockChangeReporter = new LivestockChangeReporter(";");
        assertEquals(";", livestockChangeReporter.getDelimiter());
    }

    @Test
    void createHeaderTest() {
        LivestockChangeReporter livestockChangeReporter = new LivestockChangeReporter(";");
        assertEquals("animal_unit;category;jan;feb;mar;apr;may;jun;jul;aug;sep;oct;nov;dec;summary", livestockChangeReporter.createHeader());
    }

    @Test
    void createAnnualReport() {
        LivestockChangeReporter livestockChangeReporter = new LivestockChangeReporter(";");
        Breed breed = new ReadHerdFromCsv().readCsvAsBreed(Path.of("src/test/resources/nyilvantartas_2021.csv"));
        List<String> fileContent = livestockChangeReporter.createAnnualReport(2020, breed);
        //List<String> fileContentAsMap = livestockChangeReporter.createAnnualReportAsMap(2020, breed);
        //assertEquals(fileContent, fileContentAsMap);
        try {
            Files.write(Path.of("src/test/resources/summary.csv"), fileContent);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to write file!");
        }
    }


}
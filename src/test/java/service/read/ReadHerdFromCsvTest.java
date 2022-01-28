package service.read;

import breed.Breed;
import org.junit.jupiter.api.Test;
import service.read.fromcsv.ReadHerdFromCsv;

import java.nio.file.Path;

class ReadHerdFromCsvTest {

    @Test
    void readCsvAsBreedTest() {
        Breed breed = new ReadHerdFromCsv().readCsvAsBreed(Path.of("src/test/resources/nyilvantartas_2021.csv"));
        System.out.println(breed.getHerd().size());
    }
}
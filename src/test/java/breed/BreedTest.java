package breed;

import breed.cattle.*;
import breed.supplement.AnimalUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BreedTest {

    Breed breed;

    @BeforeEach
    void init() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties firstProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration firstRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle firstCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2022-01-01"), firstProperties, firstRegistration);
        CattleProperties secondProperties = new CattleProperties("RRS",
                "white",
                "gallyas",
                "bull",
                "Vő",
                parents,
                "Szelíd");
        CattleRegistration secondRegistration = new CattleRegistration(126, "BKE 123457", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle secondCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), secondProperties, secondRegistration);
        Parents anotherParents = new Parents("HU 2345 2345 28", "HU 2345 2345 29");
        CattleProperties thirdProperties = new CattleProperties("RRR",
                "grey",
                "sodró",
                "ox",
                "Burnót",
                anotherParents,
                "Nagy marmagasságú");
        CattleRegistration thirdRegistration = new CattleRegistration(127, "BKE 123457", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle thirdCattle = new Cattle("HU 2345 2345 27", LocalDate.parse("2022-01-01"), thirdProperties, thirdRegistration);

        breed = new Breed();

        breed.addCattle(firstCattle);
        breed.addCattle(secondCattle);
        breed.addCattle(thirdCattle);
    }

    @Test
    void addCattleTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle cattle = new Cattle("HU 2345 2345 28", LocalDate.parse("2022-01-01"), properties, registration);

        breed.addCattle(cattle);
        assertEquals(4L, breed.getHerd().size());
        assertTrue(breed.getHerd().stream().anyMatch(cattle1 -> cattle1.equals(new Cattle("HU 2345 2345 28", LocalDate.of(2022, 12, 2), properties, registration))));
    }

    @Test
    void addNullCattleTest() {
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> breed.addCattle(null));
        assertEquals("Empty cattle object!", ise.getMessage());
    }

    @Test
    void addCattleWithExistingEarTagNumberTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle cattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), properties, registration);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> breed.addCattle(cattle));
        assertEquals("There is a cattle in the herd with this ear tag number: HU 2345 2345 25", iae.getMessage());
    }

    @Test
    void createLivestockChangeForMonthsBeforeDateTest() {
        assertEquals(3, breed.createLivestockChangeForMonthsBeforeDate(AnimalUnit.CALF, LocalDate.parse("2022-01-01"), 1).getLivestockGrowth().getReproduction());
    }
}
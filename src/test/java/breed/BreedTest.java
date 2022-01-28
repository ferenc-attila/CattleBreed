package breed;

import breed.cattle.Cattle;
import breed.cattle.CattleProperties;
import breed.cattle.CattleRegistration;
import breed.cattle.CauseOfIncoming;
import breed.supplement.AnimalUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BreedTest {

    Breed breed;

    @BeforeEach
    void init() {
        CattleProperties firstProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration firstRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle firstCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2022-01-01"), firstProperties, firstRegistration);
        CattleProperties secondProperties = new CattleProperties("RRS",
                "white",
                "bull",
                "Vő",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Szelíd");
        CattleRegistration secondRegistration = new CattleRegistration(126, "BKE 123457", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle secondCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), secondProperties, secondRegistration);
        CattleProperties thirdProperties = new CattleProperties("RRR",
                "grey",
                "ox",
                "Burnót",
                "HU 2345 2345 28",
                "HU 2345 2345 29",
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
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
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
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
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
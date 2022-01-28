package breed.cattle;

import breed.events.Escape;
import breed.supplement.AnimalUnit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CattleTest {

    @Test
    void createTest() {
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

        assertEquals("HU 2345 2345 25", cattle.getEarTagNumber());
        assertEquals(LocalDate.of(2022, 1, 1), cattle.getDateOfBirth());
        assertEquals("grey", cattle.getProperties().getColor());
        assertEquals("csákó", cattle.getProperties().getFormOfHorn());
        assertEquals(LocalDate.of(2022, 1, 1), cattle.getRegistration().getDateOfIncoming());
    }

    @Test
    void createWithInvalidDateOfEscapeTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Escape escape = new Escape(1, LocalDate.parse("2021-01-01"), "kényszervágás");
        registration.setEscape(escape);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), properties, registration));
        assertEquals("Invalid date of escape!", iae.getMessage());
    }

    @Test
    void copyConstructorTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle initCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), properties, registration);

        Cattle cattle = new Cattle(initCattle);

        assertEquals("HU 2345 2345 25", cattle.getEarTagNumber());
        assertEquals(LocalDate.of(2022, 1, 1), cattle.getDateOfBirth());
        assertEquals(LocalDate.of(2022, 1, 1), cattle.getRegistration().getDateOfIncoming());
    }

    @Test
    void getAgeInMonthsTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle initCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), properties, registration);

        assertEquals(0, initCattle.getAgeInMonths(LocalDate.of(2022, 1, 31)));
        assertEquals(1, initCattle.getAgeInMonths(LocalDate.of(2022, 2, 2)));
        assertEquals(2, initCattle.getAgeInMonths(LocalDate.of(2022, 3, 31)));
        assertEquals(1, initCattle.getAgeInMonths(LocalDate.of(2022, 2, 28)));
    }

    @Test
    void getAgeInMonthsTooEarlyDateTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle initCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), properties, registration);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> initCattle.getAgeInMonths(LocalDate.of(1965, 1, 1)));
        assertEquals("Invalid date: 1965-01-01! Date can't be earlier than the birthday of the cattle!", iae.getMessage());
    }

    @Test
    void getAnimalUnitTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2017-04-01"), CauseOfIncoming.BUYING, LocalDate.parse("2017-04-08"));
        Cattle initCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2017-04-01"), properties, registration);

        assertEquals(AnimalUnit.CALF, initCattle.getAnimalUnit(LocalDate.of(2017, 10, 31)));
        assertEquals(AnimalUnit.YOUNGLING, initCattle.getAnimalUnit(LocalDate.of(2017, 11, 1)));
        assertEquals(AnimalUnit.YOUNGLING, initCattle.getAnimalUnit(LocalDate.of(2019, 4, 30)));
        assertEquals(AnimalUnit.ADULT, initCattle.getAnimalUnit(LocalDate.of(2019, 5, 1)));
        assertEquals("felnőtt", initCattle.getAnimalUnit(LocalDate.of(2019, 5, 1)).getName());
    }

    @Test
    void isEscapedTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties properties = new CattleProperties("SSR",
                "white",
                "gallyas",
                "ox",
                "Hanga",
                parents,
                "Szelíd természetű");
        CattleRegistration livingRegistration = new CattleRegistration(126, "BKE 12456", LocalDate.parse("2018-04-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2018-04-08"));
        Cattle livingCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2018-04-01"), properties, livingRegistration);

        CattleProperties soldProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration soldRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2017-04-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2017-04-08"));
        Cattle soldCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2017-04-01"), soldProperties, soldRegistration);
        Escape escape = new Escape(1, LocalDate.parse("2022-01-01"), "értékesítés");
        soldCattle.getRegistration().setEscape(escape);

        assertTrue(soldCattle.isEscaped());
        assertFalse(livingCattle.isEscaped());
    }

    @Test
    void compareToTest() {
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
        CattleProperties secondProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration secondRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle secondCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), secondProperties, secondRegistration);

        List<Cattle> listOfCattle = new ArrayList<>(Arrays.asList(firstCattle, secondCattle));
        listOfCattle.sort(Comparator.naturalOrder());

        assertEquals(secondCattle, listOfCattle.get(0));
    }

    @Test
    void equalsTest() {
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
        CattleProperties secondProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration secondRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle secondCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), secondProperties, secondRegistration);
        Parents anotherParents = new Parents("HU 2345 2345 28", "HU 2345 2345 29");
        CattleProperties thirdProperties = new CattleProperties("RRR",
                "white",
                "sodró",
                "bull",
                "Burnót",
                anotherParents,
                "Szelíd");
        CattleRegistration thirdRegistration = new CattleRegistration(12, "CFD 456789", LocalDate.parse("2021-05-22"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2021-05-22"));
        Cattle thirdCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2021-05-22"), thirdProperties, thirdRegistration);

        assertNotEquals(firstCattle, secondCattle);
        assertEquals(firstCattle, thirdCattle);
    }

    @Test
    void hashCodeTest() {
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
        CattleProperties secondProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");
        CattleRegistration secondRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2022-01-08"));
        Cattle secondCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), secondProperties, secondRegistration);
        Parents anotherParents = new Parents("HU 2345 2345 28", "HU 2345 2345 29");
        CattleProperties thirdProperties = new CattleProperties("RRR",
                "white",
                "kukó",
                "bull",
                "Burnót",
                anotherParents,
                "Szelíd");
        CattleRegistration thirdRegistration = new CattleRegistration(12, "CFD 456789", LocalDate.parse("2021-05-22"), CauseOfIncoming.REPRODUCTION, LocalDate.parse("2021-05-22"));
        Cattle thirdCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2021-05-22"), thirdProperties, thirdRegistration);

        assertNotEquals(firstCattle.hashCode(), secondCattle.hashCode());
        assertEquals(firstCattle.hashCode(), thirdCattle.hashCode());
    }
}
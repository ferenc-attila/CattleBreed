package breed.cattle;

import breed.Escape;
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
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Cattle cattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), properties, registration);

        assertEquals("HU 2345 2345 25", cattle.getEarTagNumber());
        assertEquals(LocalDate.of(2022, 1, 1), cattle.getDateOfBirth());
        assertEquals("grey", cattle.getProperties().getColor());
        assertEquals(LocalDate.of(2022, 1, 1), cattle.getRegistration().getDateOfIncoming());
    }

    @Test
    void createWithInvalidDateOfEscapeTest() {
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Escape escape = new Escape(1, LocalDate.parse("2021-01-01"), "kényszervágás");
        registration.setEscape(escape);

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), properties, registration));
        assertEquals("Invalid date of escape!", iae.getMessage());
    }

    @Test
    void copyConstructorTest() {
        CattleProperties properties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Cattle initCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), properties, registration);

        Cattle cattle = new Cattle(initCattle);

        assertEquals("HU 2345 2345 25", cattle.getEarTagNumber());
        assertEquals(LocalDate.of(2022, 1, 1), cattle.getDateOfBirth());
        assertEquals(LocalDate.of(2022, 1, 1), cattle.getRegistration().getDateOfIncoming());
    }

    @Test
    void compareToTest() {
        CattleProperties firstProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration firstRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Cattle firstCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2022-01-01"), firstProperties, firstRegistration);
        CattleProperties secondProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration secondRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Cattle secondCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), secondProperties, secondRegistration);

        List<Cattle> listOfCattle = new ArrayList<>(Arrays.asList(firstCattle, secondCattle));
        listOfCattle.sort(Comparator.naturalOrder());

        assertEquals(secondCattle, listOfCattle.get(0));
    }

    @Test
    void equalsTest() {
        CattleProperties firstProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration firstRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Cattle firstCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2022-01-01"), firstProperties, firstRegistration);
        CattleProperties secondProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration secondRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Cattle secondCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), secondProperties, secondRegistration);
        CattleProperties thirdProperties = new CattleProperties("RRR",
                "white",
                "bull",
                "Burnót",
                "HU 2345 2345 28",
                "HU 2345 2345 29",
                "Szelíd");
        CattleRegistration thirdRegistration = new CattleRegistration(12, "CFD 456789", LocalDate.parse("2021-05-22"), LocalDate.parse("2021-05-22"));
        Cattle thirdCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2021-05-22"), thirdProperties, thirdRegistration);

        assertNotEquals(firstCattle, secondCattle);
        assertEquals(firstCattle, thirdCattle);
    }

    @Test
    void hashCodeTest() {
        CattleProperties firstProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration firstRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Cattle firstCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2022-01-01"), firstProperties, firstRegistration);
        CattleProperties secondProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");
        CattleRegistration secondRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Cattle secondCattle = new Cattle("HU 2345 2345 25", LocalDate.parse("2022-01-01"), secondProperties, secondRegistration);
        CattleProperties thirdProperties = new CattleProperties("RRR",
                "white",
                "bull",
                "Burnót",
                "HU 2345 2345 28",
                "HU 2345 2345 29",
                "Szelíd");
        CattleRegistration thirdRegistration = new CattleRegistration(12, "CFD 456789", LocalDate.parse("2021-05-22"), LocalDate.parse("2021-05-22"));
        Cattle thirdCattle = new Cattle("HU 2345 2345 26", LocalDate.parse("2021-05-22"), thirdProperties, thirdRegistration);

        assertNotEquals(firstCattle.hashCode(), secondCattle.hashCode());
        assertEquals(firstCattle.hashCode(), thirdCattle.hashCode());
    }
}
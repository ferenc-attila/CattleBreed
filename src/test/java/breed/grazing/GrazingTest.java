package breed.grazing;

import breed.cattle.Cattle;
import breed.cattle.CattleProperties;
import breed.cattle.CattleRegistration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GrazingTest {

    Grazing grazing;

    @BeforeEach
    void init() {
        Cattle firstCattle = new Cattle("HU 1234 5678 90", LocalDate.parse("2019-06-30"), new CattleProperties("male"), new CattleRegistration(LocalDate.parse("2019-06-30")));
        Cattle secondCattle = new Cattle("HU 1234 5678 91", LocalDate.parse("2017-04-30"), new CattleProperties("female"), new CattleRegistration(LocalDate.parse("2017-04-30")));
        Cattle thirdCattle = new Cattle("HU 1234 5678 92", LocalDate.parse("2020-02-01"), new CattleProperties("female"), new CattleRegistration(LocalDate.parse("2020-01-01")));
        Cattle fourthCattle = new Cattle("HU 1234 5678 93", LocalDate.parse("2019-06-15"), new CattleProperties("female"), new CattleRegistration(LocalDate.parse("2019-06-15")));
        Cattle fifthCattle = new Cattle("HU 1234 5678 94", LocalDate.parse("2020-06-01"), new CattleProperties("male"), new CattleRegistration(LocalDate.parse("2020-06-01")));

        grazing = new Grazing(1, LocalDate.parse("2020-06-15"), LocalDate.parse("2021-07-15"), new GrazeField(1, "Rakottyás", 125.04), "villanypásztor");

        grazing.addCattle(firstCattle);
        grazing.addCattle(secondCattle);
        grazing.addCattle(thirdCattle);
        grazing.addCattle(fourthCattle);
        grazing.addCattle(fifthCattle);
    }

    @Test
    void createTest() {
        Grazing anotherGrazing = new Grazing(0, LocalDate.parse("2021-05-01"), LocalDate.parse("2021-08-30"), new GrazeField(0, "Hamvajárás", 245.05), "pásztoroló");
        assertEquals(0, anotherGrazing.getId());
        assertEquals(LocalDate.of(2021, 5, 1), anotherGrazing.getStart());
        assertEquals(LocalDate.of(2021, 8, 30), anotherGrazing.getEnd());
        assertEquals("pásztoroló", anotherGrazing.getMode());
        assertEquals("Hamvajárás", anotherGrazing.getGrazeField().getName());
    }

    @Test
    void addCattleTest() {
        Cattle cattle = new Cattle("HU 1234 5678 95", LocalDate.parse("2019-04-30"), new CattleProperties("female"), new CattleRegistration(LocalDate.parse("2019-04-30")));
        grazing.addCattle(cattle);

        assertEquals(6, grazing.getHerd().size());
        assertTrue(grazing.getHerd().contains(new Cattle("HU 1234 5678 95", LocalDate.parse("2019-04-30"), new CattleProperties("female"), new CattleRegistration(LocalDate.parse("2019-04-30")))));
    }

    @Test
    void addNullCattleTest() {
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> grazing.addCattle(null));
        assertEquals("Empty cattle object!", ise.getMessage());
    }

    @Test
    void addCattleWithExistingEarTagNumberTest() {
        Cattle cattle = new Cattle("HU 1234 5678 90", LocalDate.parse("2019-04-30"), new CattleProperties("female"), new CattleRegistration(LocalDate.parse("2019-04-30")));

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> grazing.addCattle(cattle));
        assertEquals("There is a cattle in the herd with this ear tag number: HU 1234 5678 90", iae.getMessage());
    }

    @Test
    void calculateAnimalUnitPerHectareForADayTest() {
        assertEquals(0.02399232, grazing.calculateAnimalUnitPerHectareForADay(grazing.getStart()), 8);
    }

    @Test
    void calculateAnimalUnitPerHectareForWholePeriodTest() {
        assertEquals(0.02631416, grazing.calculateAnimalUnitPerHectareForWholePeriod(), 8);
    }
}
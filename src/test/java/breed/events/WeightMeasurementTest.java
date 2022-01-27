package breed.events;

import breed.cattle.Cattle;
import breed.cattle.CattleProperties;
import breed.cattle.CattleRegistration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WeightMeasurementTest {

    @Test
    void createTest() {
        CattleProperties properties = new CattleProperties("male");
        CattleRegistration registration = new CattleRegistration(LocalDate.parse("2021-05-04"));
        Cattle cattle = new Cattle("HU 4567 4567 89", LocalDate.parse("2021-05-04"), properties, registration);

        WeightMeasurement measurement = new WeightMeasurement(cattle, LocalDate.of(2021, 8, 25), 45.8);

        assertEquals("HU 4567 4567 89", measurement.getCattle().getEarTagNumber());
        assertEquals(LocalDate.parse("2021-08-25"), measurement.getDate());
        assertEquals(45.8, measurement.getWeight(), 1);
    }
}
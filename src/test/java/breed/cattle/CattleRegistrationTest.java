package breed.cattle;

import breed.events.Escape;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CattleRegistrationTest {

    @Test
    void createOnlyWithDateOfIncomingTest() {
        CattleRegistration registration = new CattleRegistration(LocalDate.parse("2022-01-01"));

        assertEquals(LocalDate.of(2022,1,1), registration.getDateOfIncoming());
    }

    @Test
    void createRegistrationWithDetailsTest() {
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));

        assertEquals(125, registration.getUsageNumber());
        assertEquals("BKE 123456", registration.getInventoryNumber());
        assertEquals(LocalDate.of(2022,1,1), registration.getDateOfIncoming());
        assertEquals(LocalDate.of(2022,1,8), registration.getRegistrationInEnar());
    }

    @Test
    void copyConstructorTest() {
        CattleRegistration initRegistration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));
        Escape escape = new Escape(1, LocalDate.parse("2022-01-10"), "értékesítés", "Törökök számára");
        initRegistration.setEscape(escape);

        CattleRegistration registration = new CattleRegistration(initRegistration);

        assertEquals(125, registration.getUsageNumber());
        assertEquals("BKE 123456", registration.getInventoryNumber());
        assertEquals(LocalDate.of(2022,1,1), registration.getDateOfIncoming());
        assertEquals(LocalDate.of(2022,1,8), registration.getRegistrationInEnar());
        assertEquals(1, registration.getEscape().getId());
        assertEquals(LocalDate.of(2022,1,10), registration.getEscape().getDateOfEscape());
        assertEquals("értékesítés", registration.getEscape().getCauseOfEscape());
        assertEquals("Törökök számára", registration.getEscape().getNotes());
    }

    @Test
    void setUsageNumberTest() {
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));

        registration.setUsageNumber(12345);

        assertEquals(12345, registration.getUsageNumber());
    }

    @Test
    void setInventoryNumberTest() {
        CattleRegistration registration = new CattleRegistration(125, "BKE 123456", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-01-08"));

        registration.setInventoryNumber("CDF 2345");

        assertEquals("CDF 2345", registration.getInventoryNumber());
    }

    @Test
    void setEscapeTest() {
        CattleRegistration registration = new CattleRegistration(LocalDate.parse("2022-01-01"));
        Escape escape = new Escape(1, LocalDate.parse("2022-01-10"), "értékesítés", "Törökök számára");
        registration.setEscape(escape);

        assertEquals(1, registration.getEscape().getId());
        assertEquals(LocalDate.of(2022,1,10), registration.getEscape().getDateOfEscape());
        assertEquals("értékesítés", registration.getEscape().getCauseOfEscape());
        assertEquals("Törökök számára", registration.getEscape().getNotes());
    }

    @Test
    void setRegistrationInEnarTest() {
        CattleRegistration registration = new CattleRegistration(LocalDate.parse("2022-01-01"));
        registration.setRegistrationInEnar(LocalDate.parse("2021-01-10"));

        assertEquals(LocalDate.of(2021,1,10), registration.getRegistrationInEnar());
    }
}
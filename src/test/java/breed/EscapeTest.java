package breed;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EscapeTest {

    @Test
    void createWithoutNotes() {
        Escape escape = new Escape(1, LocalDate.parse("2022-01-01"), "értékesítés");

        assertEquals(1, escape.getId());
        assertEquals(LocalDate.of(2022, 1, 1), escape.getDateOfEscape());
        assertEquals("értékesítés", escape.getCauseOfEscape());
    }

    @Test
    void createWithNotes() {
        Escape escape = new Escape(1, LocalDate.parse("2022-01-01"), "értékesítés", "Törökök számára");

        assertEquals("Törökök számára", escape.getNotes());
    }

    @Test
    void copyConstructorTest() {
        Escape initEscape = new Escape(1, LocalDate.parse("2022-01-01"), "értékesítés", "Törökök számára");

        Escape escape = new Escape(initEscape);

        assertEquals(1, escape.getId());
        assertEquals(LocalDate.of(2022, 1, 1), escape.getDateOfEscape());
        assertEquals("értékesítés", escape.getCauseOfEscape());
        assertEquals("Törökök számára", escape.getNotes());
    }

    @Test
    void setNotesTest() {
        Escape escape = new Escape(1, LocalDate.parse("2022-01-01"), "értékesítés", "Törökök számára");

        escape.setNotes("Törökök számára, 2. kamion");

        assertEquals("Törökök számára, 2. kamion", escape.getNotes());
    }
}
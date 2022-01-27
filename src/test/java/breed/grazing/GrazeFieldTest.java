package breed.grazing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrazeFieldTest {

    @Test
    void createTest() {
        GrazeField hamvajaras = new GrazeField(0, "Hamvajárás", 245.07);

        assertEquals(0, hamvajaras.getId());
        assertEquals("Hamvajárás", hamvajaras.getName());
        assertEquals(245.07, hamvajaras.getArea(), 2);
    }

    @Test
    void setNameTest() {
        GrazeField rakottyas = new GrazeField(0, "Hamvajárás", 245.07);
        rakottyas.setName("Rakottyás");
        assertEquals("Rakottyás", rakottyas.getName());
    }

    @Test
    void setAreaTest() {
        GrazeField hamvajaras = new GrazeField(0, "Hamvajárás", 245.07);
        hamvajaras.setArea(212.343);
        assertEquals(212.343, hamvajaras.getArea(), 3);
    }
}
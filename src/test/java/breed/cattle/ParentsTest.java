package breed.cattle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParentsTest {

    @Test
    void createWithMotherEarTagNumberTest() {
        Parents parents = new Parents("HU 2345 2345 23");

        assertEquals("HU 2345 2345 23", parents.getMotherEarTagNumber());
    }

    @Test
    void createWithBothParentsTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");

        assertEquals("HU 2345 2345 23", parents.getMotherEarTagNumber());
        assertEquals("HU 2345 2345 24", parents.getFatherEarTagNumber());
    }

    @Test
    void copyConstructorWithMotherEarTagNumberTest() {
        Parents origin = new Parents("HU 2345 2345 23");
        Parents parents = new Parents(origin);

        assertEquals("HU 2345 2345 23", parents.getMotherEarTagNumber());
        assertNull(parents.getFatherEarTagNumber());
    }

    @Test
    void copyConstructorWithBothParentsTest() {
        Parents origin = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        Parents parents = new Parents(origin);

        assertEquals("HU 2345 2345 23", parents.getMotherEarTagNumber());
        assertEquals("HU 2345 2345 24", parents.getFatherEarTagNumber());
    }

    @Test
    void setMotherEarTagNumberTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        parents.setMotherEarTagNumber("HU 1234 1234 56");

        assertEquals("HU 1234 1234 56", parents.getMotherEarTagNumber());
    }

    @Test
    void setFatherEarTagNumberTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        parents.setFatherEarTagNumber("HU 1234 1234 56");

        assertEquals("HU 1234 1234 56", parents.getFatherEarTagNumber());
    }
}
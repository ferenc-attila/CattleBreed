package breed.cattle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CattlePropertiesTest {

    @Test
    void createOnlyWithSexTest() {
        CattleProperties initProperties = new CattleProperties("bull");

        assertEquals("bull", initProperties.getSex());
    }

    @Test
    void createWithParentsTest() {
        CattleProperties initProperties = new CattleProperties("cow", "HU 2345 2345 23", "HU 2345 2345 24");

        assertEquals("cow", initProperties.getSex());
        assertEquals("HU 2345 2345 23", initProperties.getMotherEarTagNumber());
        assertEquals("HU 2345 2345 24", initProperties.getFatherEarTagNumber());
    }

    @Test
    void createWithEveryAttributesTest() {
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");

        assertEquals("SSR", initProperties.getPalate());
        assertEquals("grey", initProperties.getColor());
        assertEquals("float", initProperties.getSex());
        assertEquals("Bimbó", initProperties.getName());
        assertEquals("HU 2345 2345 23", initProperties.getMotherEarTagNumber());
        assertEquals("HU 2345 2345 24", initProperties.getFatherEarTagNumber());
        assertEquals("Heves természetű", initProperties.getNotes());
    }

    @Test
    void copyConstructorTest() {
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");

        CattleProperties cattleProperties = new CattleProperties(initProperties);

        assertEquals("SSR", cattleProperties.getPalate());
        assertEquals("grey", cattleProperties.getColor());
        assertEquals("float", cattleProperties.getSex());
        assertEquals("Bimbó", cattleProperties.getName());
        assertEquals("HU 2345 2345 23", cattleProperties.getMotherEarTagNumber());
        assertEquals("HU 2345 2345 24", cattleProperties.getFatherEarTagNumber());
        assertEquals("Heves természetű", cattleProperties.getNotes());
    }

    @Test
    void setPalateTest() {
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");

        initProperties.setPalate("RRS");
        assertEquals("RRS", initProperties.getPalate());
    }

    @Test
    void setColorTest() {
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");

        initProperties.setColor("white");
        assertEquals("white", initProperties.getColor());
    }

    @Test
    void setSexTest() {
        CattleProperties initProperties = new CattleProperties("bull");

        initProperties.setSex("ox");

        assertEquals("ox", initProperties.getSex());
    }

    @Test
    void setNameTest() {
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");

        initProperties.setName("Fátyol");
        assertEquals("Fátyol", initProperties.getName());
    }

    @Test
    void setMotherEarTagNumberTest() {
        CattleProperties initProperties = new CattleProperties("cow");

        initProperties.setMotherEarTagNumber("HU 2345 2345 23");

        assertEquals("HU 2345 2345 23", initProperties.getMotherEarTagNumber());

    }

    @Test
    void setFatherEarTagNumberTest() {
        CattleProperties initProperties = new CattleProperties("cow");

        initProperties.setFatherEarTagNumber("HU 2345 2345 24");

        assertEquals("HU 2345 2345 24", initProperties.getFatherEarTagNumber());
    }

    @Test
    void setNotesTest() {
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "float",
                "Bimbó",
                "HU 2345 2345 23",
                "HU 2345 2345 24",
                "Heves természetű");

        initProperties.setNotes("Nyugodt természetű");
        assertEquals("Nyugodt természetű", initProperties.getNotes());
    }
}
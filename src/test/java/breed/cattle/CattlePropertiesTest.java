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
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("cow", parents);

        assertEquals("cow", initProperties.getSex());
        assertEquals("HU 2345 2345 23", initProperties.getParents().getMotherEarTagNumber());
        assertEquals("HU 2345 2345 24", initProperties.getParents().getFatherEarTagNumber());
    }

    @Test
    void createWithEveryAttributesTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");

        assertEquals("SSR", initProperties.getPalate());
        assertEquals("grey", initProperties.getColor());
        assertEquals("csákó", initProperties.getFormOfHorn());
        assertEquals("float", initProperties.getSex());
        assertEquals("Bimbó", initProperties.getName());
        assertEquals("HU 2345 2345 23", initProperties.getParents().getMotherEarTagNumber());
        assertEquals("HU 2345 2345 24", initProperties.getParents().getFatherEarTagNumber());
        assertEquals("Heves természetű", initProperties.getNotes());
    }

    @Test
    void copyConstructorTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");

        CattleProperties cattleProperties = new CattleProperties(initProperties);

        assertEquals("SSR", cattleProperties.getPalate());
        assertEquals("grey", cattleProperties.getColor());
        assertEquals("csákó", cattleProperties.getFormOfHorn());
        assertEquals("float", cattleProperties.getSex());
        assertEquals("Bimbó", cattleProperties.getName());
        assertEquals("HU 2345 2345 23", cattleProperties.getParents().getMotherEarTagNumber());
        assertEquals("HU 2345 2345 24", cattleProperties.getParents().getFatherEarTagNumber());
        assertEquals("Heves természetű", cattleProperties.getNotes());
    }

    @Test
    void setPalateTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");

        initProperties.setPalate("RRS");
        assertEquals("RRS", initProperties.getPalate());
    }

    @Test
    void setColorTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");

        initProperties.setColor("white");
        assertEquals("white", initProperties.getColor());
    }

    @Test
    void setFormOfHornTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");

        initProperties.setFormOfHorn("gallyas");
        assertEquals("gallyas", initProperties.getFormOfHorn());
    }

    @Test
    void setParentsTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");

        initProperties.setParents(new Parents("HU 1234 1234 56"));

        assertEquals("HU 1234 1234 56", initProperties.getParents().getMotherEarTagNumber());
        assertNull(initProperties.getParents().getFatherEarTagNumber());

        initProperties.setParents(new Parents("HU 5678 5678 90", "HU 2468 2468 13"));

        assertEquals("HU 5678 5678 90", initProperties.getParents().getMotherEarTagNumber());
        assertEquals("HU 2468 2468 13", initProperties.getParents().getFatherEarTagNumber());
    }

    @Test
    void setSexTest() {
        CattleProperties initProperties = new CattleProperties("bull");

        initProperties.setSex("ox");

        assertEquals("ox", initProperties.getSex());
    }

    @Test
    void setNameTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");

        initProperties.setName("Fátyol");
        assertEquals("Fátyol", initProperties.getName());
    }

    @Test
    void setNotesTest() {
        Parents parents = new Parents("HU 2345 2345 23", "HU 2345 2345 24");
        CattleProperties initProperties = new CattleProperties("SSR",
                "grey",
                "csákó",
                "float",
                "Bimbó",
                parents,
                "Heves természetű");

        initProperties.setNotes("Nyugodt természetű");
        assertEquals("Nyugodt természetű", initProperties.getNotes());
    }
}
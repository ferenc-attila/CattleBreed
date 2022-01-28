package service.write;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivestockChangeStringTest {

    @Test
    void createTest() {
        LivestockChangeString livestockChangeString = new LivestockChangeString(";");
        assertEquals(";", livestockChangeString.getDelimiter());
    }

    @Test
    void createHeaderTest() {
        LivestockChangeString livestockChangeString = new LivestockChangeString(";");
        assertEquals("category;jan;feb;mar;apr;may;jun;jul;aug;sep;oct;nov;dec;summary", livestockChangeString.createHeader());
    }
}
package farminglog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivestockDecreaseTest {

    LivestockDecrease livestockDecrease;

    @BeforeEach
    void init() {
        livestockDecrease = new LivestockDecrease(2, 24, 12, 1);
    }

    @Test
    void createTest() {
        LivestockDecrease decrease = new LivestockDecrease(3, 11, 5, 2);

        assertEquals(3, decrease.getDeath());
        assertEquals(11, decrease.getSelling());
        assertEquals(5, decrease.getReclassification());
        assertEquals(2, decrease.getScrapping());
    }

    @Test
    void getSumOfDecreaseTest() {
        assertEquals(39, livestockDecrease.getSumOfDecrease());
    }

    @Test
    void getSumOfReclassificationAndScrappingTest() {
        assertEquals(13, livestockDecrease.getSumOfReclassificationAndScrapping());
    }
}
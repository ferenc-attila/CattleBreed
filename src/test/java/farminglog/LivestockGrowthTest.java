package farminglog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivestockGrowthTest {

    @Test
    void createTest() {
        LivestockGrowth livestockGrowth = new LivestockGrowth(7, 3, 15);

        assertEquals(7, livestockGrowth.getReproduction());
        assertEquals(3, livestockGrowth.getBuying());
        assertEquals(15, livestockGrowth.getReclassification());
    }

    @Test
    void getSumOfGrowthTest() {
        LivestockGrowth livestockGrowth = new LivestockGrowth(12, 5, 18);

        assertEquals(35, livestockGrowth.getSumOfGrowth());
    }
}
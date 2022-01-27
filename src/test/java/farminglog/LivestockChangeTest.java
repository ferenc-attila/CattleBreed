package farminglog;

import breed.supplement.AnimalUnit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LivestockChangeTest {

    @Test
    void createTest() {
        LivestockGrowth livestockGrowth = new LivestockGrowth(5, 12, 3);
        LivestockDecrease liveStockDecrease = new LivestockDecrease(1, 3, 5, 2);
        LivestockChange livestockChange = new LivestockChange("magyar szürke szarvasmarha", AnimalUnit.YOUNGLING, LocalDate.parse("2021-01-01"), 124, livestockGrowth, liveStockDecrease);

        assertEquals("magyar szürke szarvasmarha", livestockChange.getBreed());
        assertEquals("növendék", livestockChange.getAnimalUnit().getName());
        assertEquals(LocalDate.of(2021, 1, 1), livestockChange.getDate());
        assertEquals(124, livestockChange.getStartingStock());
        assertEquals(5, livestockChange.getLivestockGrowth().getReproduction());
        assertEquals(3, livestockChange.getLivestockDecrease().getSelling());
    }

    @Test
    void getFullStockTest() {
        LivestockGrowth livestockGrowth = new LivestockGrowth(5, 12, 3);
        LivestockDecrease liveStockDecrease = new LivestockDecrease(1, 3, 5, 2);
        LivestockChange livestockChange = new LivestockChange("magyar szürke szarvasmarha", AnimalUnit.YOUNGLING, LocalDate.parse("2021-01-01"), 124, livestockGrowth, liveStockDecrease);

        assertEquals(133, livestockChange.getFullStock());
    }
}
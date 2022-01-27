package farminglog;

import breed.supplement.AnimalUnit;

import java.time.LocalDate;

public class LivestockChange {

    private String breed;
    private AnimalUnit animalUnit;
    private LocalDate date;
    private int startingStock;
    private LivestockGrowth livestockGrowth;
    private LivestockDecrease livestockDecrease;

    public LivestockChange(String breed, AnimalUnit animalUnit, LocalDate date, int startingStock, LivestockGrowth livestockGrowth, LivestockDecrease livestockDecrease) {
        this.breed = breed;
        this.animalUnit = animalUnit;
        this.date = date;
        this.startingStock = startingStock;
        this.livestockGrowth = livestockGrowth;
        this.livestockDecrease = livestockDecrease;
    }

    public int getFullStock() {
        return startingStock + livestockGrowth.getSumOfGrowth() - livestockDecrease.getSumOfDecrease();
    }

    public String getBreed() {
        return breed;
    }

    public AnimalUnit getAnimalUnit() {
        return animalUnit;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getStartingStock() {
        return startingStock;
    }

    public LivestockGrowth getLivestockGrowth() {
        return livestockGrowth;
    }

    public LivestockDecrease getLivestockDecrease() {
        return livestockDecrease;
    }
}

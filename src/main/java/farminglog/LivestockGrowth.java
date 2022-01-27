package farminglog;

public class LivestockGrowth {

    private int reproduction;
    private int buying;
    private int reclassification;

    public LivestockGrowth(int reproduction, int buying, int reclassification) {
        this.reproduction = reproduction;
        this.buying = buying;
        this.reclassification = reclassification;
    }

    public int getSumOfGrowth() {
        return reproduction + buying + reclassification;
    }

    public int getReproduction() {
        return reproduction;
    }

    public int getBuying() {
        return buying;
    }

    public int getReclassification() {
        return reclassification;
    }
}

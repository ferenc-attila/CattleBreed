package farminglog;

public class LivestockDecrease {

    private int death;
    private int selling;
    private int reclassification;
    private int scrapping;

    public LivestockDecrease(int death, int selling, int reclassification, int scrapping) {
        this.death = death;
        this.selling = selling;
        this.reclassification = reclassification;
        this.scrapping = scrapping;
    }

    public int getSumOfDecrease() {
        return death + selling + getSumOfReclassificationAndScrapping();
    }

    public int getSumOfReclassificationAndScrapping() {
        return reclassification + scrapping;
    }

    public int getDeath() {
        return death;
    }

    public int getSelling() {
        return selling;
    }

    public int getReclassification() {
        return reclassification;
    }

    public int getScrapping() {
        return scrapping;
    }
}

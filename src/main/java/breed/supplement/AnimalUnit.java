package breed.supplement;

public enum AnimalUnit {

    CALF("borjú", 0.4, 0, 6),
    YOUNGLING("növendék", 0.6, 7, 24),
    ADULT("felnőtt", 1, 25, Integer.MAX_VALUE);

    private final String name;
    private final double multiplier;
    private final int minMonths;
    private final int maxMonths;

    AnimalUnit(String name, double multiplier, int minMonths, int maxMonths) {
        this.name = name;
        this.multiplier = multiplier;
        this.minMonths = minMonths;
        this.maxMonths = maxMonths;
    }

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public int getMinMonths() {
        return minMonths;
    }

    public int getMaxMonths() {
        return maxMonths;
    }
}

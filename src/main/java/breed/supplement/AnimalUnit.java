package breed.supplement;

public enum AnimalUnit {

    CALF("borjú", 0.4),
    YOUNGLING("növendék", 0.6),
    ADULT("felnőtt", 1);

    private String name;
    private double multiplier;

    AnimalUnit(String name, double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }
}

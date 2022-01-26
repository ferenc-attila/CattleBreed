package breed.events;

import breed.cattle.Cattle;

import java.time.LocalDate;

public class WeightMeasurement {

    private Cattle cattle;
    private LocalDate date;
    private double weight;

    public WeightMeasurement(Cattle cattle, LocalDate date, double weight) {
        this.cattle = cattle;
        this.date = date;
        this.weight = weight;
    }

    public Cattle getCattle() {
        return cattle;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getWeight() {
        return weight;
    }
}

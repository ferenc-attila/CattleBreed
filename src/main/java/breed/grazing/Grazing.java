package breed.grazing;

import breed.cattle.Cattle;

import java.time.LocalDate;
import java.util.*;

public class Grazing {

    private int id;
    private LocalDate start;
    private LocalDate end;
    private Set<Cattle> herd = new TreeSet<>();
    private GrazeField grazeField;
    private String mode;

    public Grazing(int id, LocalDate start, LocalDate end, GrazeField grazeField, String mode) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.grazeField = grazeField;
        this.mode = mode;
    }

    public void addCattle(Cattle cattle) {
        validateCattle(cattle);
        herd.add(cattle);
    }

    private void validateCattle(Cattle cattle) {
        if (cattle == null) {
            throw new IllegalStateException("Empty cattle object!");
        }
        if (isInHerd(cattle.getEarTagNumber())) {
            throw new IllegalArgumentException("There is a cattle in the herd with this ear tag number: " + cattle.getEarTagNumber());
        }
    }

    private boolean isInHerd(String earTagNumber) {
        return herd.stream().anyMatch(cattle -> cattle.getEarTagNumber().equals(earTagNumber));
    }

    public double calculateAnimalUnitPerHectareForADay(LocalDate date) {
        return herd.stream()
                .mapToDouble(cattle -> cattle.getAnimalUnit(date).getMultiplier())
                .sum() / grazeField.getArea();
    }

    public double calculateAnimalUnitPerHectareForWholePeriod() {
        List<LocalDate> dates = getGrazingDates();
        return dates.stream()
                .mapToDouble(this::calculateAnimalUnitPerHectareForADay)
                .sum() / dates.size();
    }

    private List<LocalDate> getGrazingDates() {
        List<LocalDate> dates = new LinkedList<>();
        LocalDate actual = start;
        while (actual.isBefore(end)) {
            dates.add(actual);
            actual = actual.plusDays(1);
        }
        return dates;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public Set<Cattle> getHerd() {
        return Set.copyOf(herd);
    }

    public GrazeField getGrazeField() {
        return grazeField;
    }

    public String getMode() {
        return mode;
    }
}

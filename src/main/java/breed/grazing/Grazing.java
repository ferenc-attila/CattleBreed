package breed.grazing;

import breed.cattle.Cattle;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Grazing {

    private int id;
    private LocalDate start;
    private LocalDate end;
    private List<Cattle> herd;
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
        herd.add(cattle);
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
                .sum();
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
}

package breed;

import breed.cattle.Cattle;
import breed.cattle.CauseOfIncoming;
import breed.supplement.AnimalUnit;
import farminglog.LivestockChange;
import farminglog.LivestockDecrease;
import farminglog.LivestockGrowth;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Breed {

    private Set<Cattle> herd = new TreeSet<>();

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

    public LivestockChange createLivestockChangeForMonthsBeforeDate(AnimalUnit animalUnit, LocalDate date, int months) {
        int startingStock = (int) getStartingStock(animalUnit, date, months);
        LivestockGrowth livestockGrowth = createLivestockGrowth(animalUnit, date, months);
        LivestockDecrease livestockDecrease = createLivestockDecrease(animalUnit, date, months);
        return new LivestockChange("magyar szürke szarvasmarha", animalUnit, date, startingStock, livestockGrowth, livestockDecrease);
    }

    private LivestockDecrease createLivestockDecrease(AnimalUnit animalUnit, LocalDate date, int months) {
        int death = (int) getNumberOfSpecificCauseOfEscape(animalUnit, date, months, "death");
        int selling = (int) getNumberOfSpecificCauseOfEscape(animalUnit, date, months, "selling");
        int reclassification = (int) getNumberOfReclassificationsForDecrease(animalUnit, date, months);
        int scrapping = (int) getNumberOfSpecificCauseOfEscape(animalUnit, date, months, "scrapping");
        return new LivestockDecrease(death, selling, reclassification, scrapping);
    }

    private long getNumberOfSpecificCauseOfEscape(AnimalUnit animalUnit, LocalDate date, int months, String cause) {
        return herd.stream()
                .filter(cattle -> cattle.getAnimalUnit(date).equals(animalUnit))
                .filter(Cattle::isEscaped)
                .filter(cattle -> cattle.getRegistration().getEscape().getCauseOfEscape().equals(cause))
                .filter(cattle -> cattle.getRegistration().getEscape().getDateOfEscape().isAfter(date.minusMonths(months))
                        || cattle.getRegistration().getEscape().getDateOfEscape().equals(date.minusMonths(months)))
                .filter(cattle -> cattle.getRegistration().getEscape().getDateOfEscape().isBefore(date)
                        || cattle.getRegistration().getEscape().getDateOfEscape().equals(date))
                .count();
    }

    private LivestockGrowth createLivestockGrowth(AnimalUnit animalUnit, LocalDate date, int months) {
        int reproduction = (int) getNumberOfReproductions(animalUnit, date, months);
        int buying = (int) getNumberOfBuyings(animalUnit, date, months);
        int reclassification = (int) getNumberOfReclassificationsForGrowth(animalUnit, date, months);
        return new LivestockGrowth(reproduction, buying, reclassification);
    }

    private long getNumberOfReclassificationsForDecrease(AnimalUnit animalUnit, LocalDate date, int months) {
        return herd.stream()
                .filter(cattle -> cattle.getAnimalUnit(getLatestDate(cattle.getDateOfBirth(), date.minusMonths(months))) == animalUnit)
                .filter(cattle -> cattle.getAnimalUnit(date) != animalUnit)
                .count();
    }

    private long getNumberOfReclassificationsForGrowth(AnimalUnit animalUnit, LocalDate date, int months) {
        return herd.stream()
                .filter(cattle -> cattle.getAnimalUnit(date) == animalUnit)
                .filter(cattle -> cattle.getAnimalUnit(getLatestDate(cattle.getDateOfBirth(), date.minusMonths(months))) != animalUnit)
                .count();
    }

    private LocalDate getLatestDate(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isAfter(secondDate)) {
            return firstDate;
        }
        return secondDate;
    }

    private long getNumberOfBuyings(AnimalUnit animalUnit, LocalDate date, int months) {
        return herd.stream()
                .filter(cattle -> cattle.getAnimalUnit(date).equals(animalUnit))
                .filter(cattle -> cattle.getRegistration().getDateOfIncoming().isAfter(date.minusMonths(months))
                        || cattle.getRegistration().getDateOfIncoming().equals(date.minusMonths(months)))
                .filter(cattle -> cattle.getRegistration().getDateOfIncoming().isBefore(date)
                        || cattle.getRegistration().getDateOfIncoming().equals(date))
                .filter(cattle -> cattle.getRegistration().getCauseOfIncoming() == CauseOfIncoming.BUYING)
                .count();

    }

    private long getNumberOfReproductions(AnimalUnit animalUnit, LocalDate date, int months) {
        long reproduction = 0;
        if (animalUnit == AnimalUnit.CALF) {
            reproduction = herd.stream()
                    .filter(cattle -> cattle.getRegistration().getCauseOfIncoming() == CauseOfIncoming.REPRODUCTION)
                    .filter(cattle -> cattle.getDateOfBirth().isAfter(date.minusMonths(months)) || cattle.getDateOfBirth().equals(date.minusMonths(months)))
                    .filter(cattle -> cattle.getDateOfBirth().isBefore(date) || cattle.getDateOfBirth().equals(date))
                    .count();
        }
        return reproduction;
    }

    private long getStartingStock(AnimalUnit animalUnit, LocalDate date, int months) {
        return herd.stream()
                .filter(cattle -> cattle.getDateOfBirth().isBefore(date.minusMonths(months)) || cattle.getDateOfBirth().equals(date.minusMonths(months)))
                .filter(Predicate.not(Cattle::isEscaped))
                .filter(cattle -> cattle.getAnimalUnit(date) == animalUnit)
                .count();
    }

    private boolean isInHerd(String earTagNumber) {
        return herd.stream().anyMatch(cattle -> cattle.getEarTagNumber().equals(earTagNumber));
    }

    public Set<Cattle> getHerd() {
        return Set.copyOf(herd);
    }
}

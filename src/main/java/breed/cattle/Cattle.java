package breed.cattle;

import breed.supplement.AnimalUnit;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Cattle implements Comparable<Cattle> {

    private final String earTagNumber;
    private final LocalDate dateOfBirth;
    private CattleProperties properties;
    private CattleRegistration registration;

    public Cattle(String earTagNumber, LocalDate dateOfBirth, CattleProperties properties, CattleRegistration registration) {
        this.earTagNumber = earTagNumber;
        this.dateOfBirth = dateOfBirth;
        this.properties = properties;
        validateRegistration(registration);
        this.registration = registration;
    }

    public Cattle(Cattle cattle) {
        earTagNumber = cattle.earTagNumber;
        dateOfBirth = cattle.dateOfBirth;
        properties = new CattleProperties(cattle.properties);
        registration = new CattleRegistration(cattle.registration);
    }

    private void validateRegistration(CattleRegistration registration) {
        if (registration.getEscape() != null && registration.getEscape().getDateOfEscape().isBefore(this.dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date of escape!");
        }
    }

    public int getAgeInMonths(LocalDate date) {
        if (date.isBefore(this.dateOfBirth)) {
            date = dateOfBirth;
            //throw new IllegalArgumentException("Invalid date: " + date + "! Date can't be earlier than the birthday of the cattle!");
        }
        return Period.between(this.dateOfBirth, date).getYears() * 12 + Period.between(this.dateOfBirth, date).getMonths();
    }

    public AnimalUnit getAnimalUnit(LocalDate date) {
        if (getAgeInMonths(date) <= AnimalUnit.CALF.getMaxMonths()) {
            return AnimalUnit.CALF;
        } else if (getAgeInMonths(date) <= AnimalUnit.YOUNGLING.getMaxMonths()) {
            return AnimalUnit.YOUNGLING;
        } else
            return AnimalUnit.ADULT;
    }

    public boolean isEscaped() {
        return this.registration.getEscape() != null;
    }

    @Override
    public int compareTo(Cattle o) {
        return this.earTagNumber.compareTo(o.earTagNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cattle cattle = (Cattle) o;
        return earTagNumber.equals(cattle.earTagNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earTagNumber);
    }

    public String getEarTagNumber() {
        return earTagNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public CattleProperties getProperties() {
        return properties;
    }

    public CattleRegistration getRegistration() {
        return registration;
    }
}

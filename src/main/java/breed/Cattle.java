package breed;

import java.time.LocalDate;

public class Cattle {

    private String earTagNumber;
    private LocalDate dateOfBirth;
    private CattleProperties properties;
    private CattleRegistration registration;

    public Cattle(String earTagNumber, LocalDate dateOfBirth, CattleProperties properties, CattleRegistration registration) {
        this.earTagNumber = earTagNumber;
        this.dateOfBirth = dateOfBirth;
        this.properties = properties;
        this.registration = registration;
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

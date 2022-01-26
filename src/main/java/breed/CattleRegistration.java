package breed;

import java.time.LocalDate;

public class CattleRegistration {

    private int usageNumber;
    private String inventoryNumber;
    private LocalDate registrationInBreed;
    private Escape escape;
    private LocalDate registrationInEnar;

    public CattleRegistration(int usageNumber, String inventoryNumber, LocalDate registrationInBreed, Escape escape, LocalDate registrationInEnar) {
        this.usageNumber = usageNumber;
        this.inventoryNumber = inventoryNumber;
        this.registrationInBreed = registrationInBreed;
        this.escape = escape;
        this.registrationInEnar = registrationInEnar;
    }

    public int getUsageNumber() {
        return usageNumber;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public LocalDate getRegistrationInBreed() {
        return registrationInBreed;
    }

    public Escape getEscape() {
        return escape;
    }

    public LocalDate getRegistrationInEnar() {
        return registrationInEnar;
    }
}

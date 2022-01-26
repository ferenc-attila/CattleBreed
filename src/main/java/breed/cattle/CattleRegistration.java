package breed.cattle;

import breed.events.Escape;

import java.time.LocalDate;

public class CattleRegistration {

    private int usageNumber;
    private String inventoryNumber;
    private LocalDate dateOfIncoming;
    private Escape escape = null;
    private LocalDate registrationInEnar;

    public CattleRegistration(LocalDate dateOfIncoming) {
        this.dateOfIncoming = dateOfIncoming;
    }

    public CattleRegistration(int usageNumber, String inventoryNumber, LocalDate dateOfIncoming, LocalDate registrationInEnar) {
        this(dateOfIncoming);
        this.usageNumber = usageNumber;
        this.inventoryNumber = inventoryNumber;
        this.registrationInEnar = registrationInEnar;
    }

    public CattleRegistration(CattleRegistration cattleRegistration) {
        usageNumber = cattleRegistration.usageNumber;
        inventoryNumber = cattleRegistration.inventoryNumber;
        dateOfIncoming = cattleRegistration.dateOfIncoming;
        if (escape != null) {
            escape = new Escape(cattleRegistration.escape);
        } else {
            escape = null;
        }
        registrationInEnar = cattleRegistration.registrationInEnar;
    }

    public int getUsageNumber() {
        return usageNumber;
    }

    public void setUsageNumber(int usageNumber) {
        this.usageNumber = usageNumber;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public LocalDate getDateOfIncoming() {
        return dateOfIncoming;
    }

    public Escape getEscape() {
        return escape;
    }

    public void setEscape(Escape escape) {
        this.escape = escape;
    }

    public LocalDate getRegistrationInEnar() {
        return registrationInEnar;
    }

    public void setRegistrationInEnar(LocalDate registrationInEnar) {
        this.registrationInEnar = registrationInEnar;
    }
}

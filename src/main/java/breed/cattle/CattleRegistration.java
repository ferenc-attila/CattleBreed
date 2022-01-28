package breed.cattle;

import breed.events.Escape;

import java.time.LocalDate;

public class CattleRegistration {

    private int usageNumber;
    private String inventoryNumber;
    private LocalDate dateOfIncoming;
    private CauseOfIncoming causeOfIncoming;
    private Escape escape = null;
    private LocalDate registrationInEnar;

    public CattleRegistration(LocalDate dateOfIncoming, CauseOfIncoming causeOfIncoming) {
        this.dateOfIncoming = dateOfIncoming;
        this.causeOfIncoming = causeOfIncoming;
    }

    public CattleRegistration(int usageNumber, String inventoryNumber, LocalDate dateOfIncoming, CauseOfIncoming causeOfIncoming, LocalDate registrationInEnar) {
        this(dateOfIncoming, causeOfIncoming);
        this.usageNumber = usageNumber;
        this.inventoryNumber = inventoryNumber;
        this.registrationInEnar = registrationInEnar;
    }

    public CattleRegistration(CattleRegistration cattleRegistration) {
        usageNumber = cattleRegistration.usageNumber;
        inventoryNumber = cattleRegistration.inventoryNumber;
        dateOfIncoming = cattleRegistration.dateOfIncoming;
        causeOfIncoming = cattleRegistration.causeOfIncoming;
        if (cattleRegistration.escape != null) {
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

    public CauseOfIncoming getCauseOfIncoming() {
        return causeOfIncoming;
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

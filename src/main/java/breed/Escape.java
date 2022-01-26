package breed;

import java.time.LocalDate;

public class Escape {

    private int id;
    private LocalDate dateOfEscape;
    private String causeOfEscape;

    public Escape(int id, LocalDate dateOfEscape, String causeOfEscape) {
        this.id = id;
        this.dateOfEscape = dateOfEscape;
        this.causeOfEscape = causeOfEscape;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateOfEscape() {
        return dateOfEscape;
    }

    public String getCauseOfEscape() {
        return causeOfEscape;
    }
}

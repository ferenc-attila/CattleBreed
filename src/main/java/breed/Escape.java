package breed;

import java.time.LocalDate;

public class Escape {

    private int id;
    private LocalDate dateOfEscape;
    private String causeOfEscape;
    private String notes;

    public Escape(int id, LocalDate dateOfEscape, String causeOfEscape) {
        this.id = id;
        this.dateOfEscape = dateOfEscape;
        this.causeOfEscape = causeOfEscape;
    }

    public Escape(int id, LocalDate dateOfEscape, String causeOfEscape, String notes) {
        this(id, dateOfEscape, causeOfEscape);
        this.notes = notes;
    }

    public Escape(Escape escape) {
        if (escape != null) {
            id = escape.id;
            dateOfEscape = escape.dateOfEscape;
            causeOfEscape = escape.causeOfEscape;
            notes = escape.notes;
        }
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

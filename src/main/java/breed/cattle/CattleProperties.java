package breed.cattle;

public class CattleProperties {

    private String palate;
    private String color;
    private String sex;
    private String name;
    private String motherEarTagNumber;
    private String fatherEarTagNumber;
    private String notes;

    public CattleProperties(String sex) {
        this.sex = sex;
    }

    public CattleProperties(String sex, String motherEarTagNumber, String fatherEarTagNumber) {
        this(sex);
        this.motherEarTagNumber = motherEarTagNumber;
        this.fatherEarTagNumber = fatherEarTagNumber;
    }

    public CattleProperties(String palate, String color, String sex, String name, String motherEarTagNumber, String fatherEarTagNumber, String notes) {
        this(sex, motherEarTagNumber, fatherEarTagNumber);
        this.palate = palate;
        this.color = color;
        this.name = name;
        this.notes = notes;
    }

    public CattleProperties(CattleProperties cattleProperties) {
        palate = cattleProperties.palate;
        color = cattleProperties.color;
        sex = cattleProperties.sex;
        name = cattleProperties.name;
        motherEarTagNumber = cattleProperties.motherEarTagNumber;
        fatherEarTagNumber = cattleProperties.fatherEarTagNumber;
        notes = cattleProperties.notes;
    }

    public String getPalate() {
        return palate;
    }

    public void setPalate(String palate) {
        this.palate = palate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotherEarTagNumber() {
        return motherEarTagNumber;
    }

    public void setMotherEarTagNumber(String motherEarTagNumber) {
        this.motherEarTagNumber = motherEarTagNumber;
    }

    public String getFatherEarTagNumber() {
        return fatherEarTagNumber;
    }

    public void setFatherEarTagNumber(String fatherEarTagNumber) {
        this.fatherEarTagNumber = fatherEarTagNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

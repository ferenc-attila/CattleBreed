package breed;

public class CattleProperties {

    private String palate;
    private String color;
    private String sex;
    private String name;
    private String motherEarTagNumber;
    private String fatherEarTagNumber;

    public CattleProperties(String palate, String color, String sex, String name, String motherEarTagNumber, String fatherEarTagNumber) {
        this.palate = palate;
        this.color = color;
        this.sex = sex;
        this.name = name;
        this.motherEarTagNumber = motherEarTagNumber;
        this.fatherEarTagNumber = fatherEarTagNumber;
    }

    public String getPalate() {
        return palate;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getMotherEarTagNumber() {
        return motherEarTagNumber;
    }

    public String getFatherEarTagNumber() {
        return fatherEarTagNumber;
    }
}

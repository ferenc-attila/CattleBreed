package breed.cattle;

public class Parents {

    private String motherEarTagNumber;
    private String fatherEarTagNumber;

    public Parents(String motherEarTagNumber) {
        this.motherEarTagNumber = motherEarTagNumber;
    }

    public Parents(String motherEarTagNumber, String fatherEarTagNumber) {
        this(motherEarTagNumber);
        this.fatherEarTagNumber = fatherEarTagNumber;
    }

    public Parents(Parents parents) {
        motherEarTagNumber = parents.motherEarTagNumber;
        fatherEarTagNumber = parents.fatherEarTagNumber;
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
}

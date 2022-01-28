package breed.cattle;

public enum CauseOfIncoming {

    REPRODUCTION("reproduction"), BUYING("buying");

    private String description;

    CauseOfIncoming(String description) {
        this.description = description;
    }
}

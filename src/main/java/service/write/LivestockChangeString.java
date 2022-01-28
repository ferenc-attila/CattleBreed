package service.write;

import java.time.Month;
import java.util.Arrays;

public class LivestockChangeString {

    private String delimiter;

    public LivestockChangeString(String delimiter) {
        this.delimiter = delimiter;
    }

    public String createHeader() {
        StringBuilder header = new StringBuilder("category;");
        Arrays.stream(Month.values())
                .forEach(month -> header.append(month.name().toLowerCase().substring(0,3)).append(delimiter));
        header.append("summary");
        return header.toString();
    }

    public String getDelimiter() {
        return delimiter;
    }
}

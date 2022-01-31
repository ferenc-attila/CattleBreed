package service.write;

import breed.Breed;
import breed.supplement.AnimalUnit;
import farminglog.LivestockChange;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LivestockChangeReporter {

    private static final List<String> ROW_NAMES = Arrays.asList("starting_stock", "reproduction", "buying", "reclassification", "total_growing",
            "death", "selling", "reclassification_scrapping", "total_decreasing", "summary");

    private final String delimiter;
    private int dataColumnCounter;

    public LivestockChangeReporter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String createHeader() {
        StringBuilder header = new StringBuilder("animal_unit").append(delimiter).append("category");
        Arrays.stream(Month.values())
                .forEach(month -> header.append(delimiter).append(month.name().substring(0, 3).toLowerCase()));
        header.append(delimiter).append(ROW_NAMES.get(9));
        return header.toString();
    }

    public List<String> createAnnualReport(int year, Breed breed) {
        List<LivestockChange> livestockChanges = breed.createAnnualLivestockChange(year);
        List<String> report = new ArrayList<>();
        report.add(createHeader());
        for (AnimalUnit actual : AnimalUnit.values()) {
            dataColumnCounter = 0;
            createColumn(livestockChanges, report, actual, LivestockChange::getStartingStock);
            createColumn(livestockChanges, report, actual, l -> l.getLivestockGrowth().getReproduction());
            createColumn(livestockChanges, report, actual, l -> l.getLivestockGrowth().getBuying());
            createColumn(livestockChanges, report, actual, l -> l.getLivestockGrowth().getReclassification());
            createColumn(livestockChanges, report, actual, l -> l.getLivestockGrowth().getSumOfGrowth());
            createColumn(livestockChanges, report, actual, l -> l.getLivestockDecrease().getDeath());
            createColumn(livestockChanges, report, actual, l -> l.getLivestockDecrease().getSelling());
            createColumn(livestockChanges, report, actual, l -> l.getLivestockDecrease().getSumOfReclassificationAndScrapping());
            createColumn(livestockChanges, report, actual, l -> l.getLivestockDecrease().getSumOfDecrease());
            createColumn(livestockChanges, report, actual, LivestockChange::getFullStock);
        }
        return report;
    }

    private void createColumn(List<LivestockChange> livestockChanges, List<String> report, AnimalUnit animalUnit, Function<LivestockChange, Integer> getValue) {
        StringBuilder sb = new StringBuilder();
        sb.append(animalUnit.getName()).append(delimiter).append(ROW_NAMES.get(dataColumnCounter)).append(delimiter);
        sb.append(livestockChanges.stream()
                        .filter(data -> data.getAnimalUnit().equals(animalUnit))
                        .map(getValue)
                        .map(Object::toString)
                        .collect(Collectors.joining(delimiter)))
                .append(delimiter).append(calculateSum(livestockChanges, animalUnit, getValue));
        report.add(sb.toString());
        sb.delete(0, sb.length());
        dataColumnCounter++;
    }

    private String calculateSum(List<LivestockChange> livestockChanges, AnimalUnit animalUnit, Function<LivestockChange, Integer> getValue) {
        if (ROW_NAMES.get(dataColumnCounter).equals(ROW_NAMES.get(ROW_NAMES.size() - 1)) || ROW_NAMES.get(dataColumnCounter).equals(ROW_NAMES.get(0))) {
            return "";
        }
        long sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(animalUnit))
                .map(getValue)
                .mapToInt(i -> i)
                .sum();
        return Long.toString(sum);
    }

    public String getDelimiter() {
        return delimiter;
    }
}

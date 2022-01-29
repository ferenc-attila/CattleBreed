package service.write;

import breed.Breed;
import breed.supplement.AnimalUnit;
import farminglog.LivestockChange;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LivestockChangeReporter {

    private String delimiter;

    public LivestockChangeReporter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String createHeader() {
        StringBuilder header = new StringBuilder("animal_unit").append(delimiter).append("category");
        Arrays.stream(Month.values())
                .forEach(month -> header.append(delimiter).append(month.name().substring(0, 3).toLowerCase()));
        header.append(delimiter).append("summary");
        return header.toString();
    }

    public List<String> createAnnualReport(int year, Breed breed) {
        List<LivestockChange> livestockChanges = breed.createAnnualLivestockChange(year);
        List<String> report = new ArrayList<>();
        report.add(createHeader());
        for (AnimalUnit actual : AnimalUnit.values()) {
            StringBuilder startingStock = new StringBuilder();
            startingStock.append(actual.getName()).append(delimiter).append("starting_stock");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> startingStock.append(delimiter).append(data.getStartingStock()));
            report.add(startingStock.toString());
            startingStock.delete(0, startingStock.length());

            StringBuilder reproduction = new StringBuilder(actual.getName()).append(delimiter).append("reproduction");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> reproduction.append(delimiter).append(data.getLivestockGrowth().getReproduction()));
            long sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual))
                    .mapToInt(data -> data.getLivestockGrowth().getReproduction()).sum();
            reproduction.append(delimiter).append(sum);
            report.add(reproduction.toString());
            reproduction.delete(0, reproduction.length());

            StringBuilder buying = new StringBuilder(actual.getName()).append(delimiter).append("buying");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> buying.append(delimiter).append(data.getLivestockGrowth().getBuying()));
            sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual))
                    .mapToInt(data -> data.getLivestockGrowth().getBuying()).sum();
            buying.append(delimiter).append(sum);
            report.add(buying.toString());
            buying.delete(0, buying.length());

            StringBuilder reclassification = new StringBuilder(actual.getName()).append(delimiter).append("reclassification");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> reclassification.append(delimiter).append(data.getLivestockGrowth().getReclassification()));
            sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual))
                    .mapToInt(data -> data.getLivestockGrowth().getReclassification()).sum();
            reclassification.append(delimiter).append(sum);
            report.add(reclassification.toString());
            reclassification.delete(0, reclassification.length());

            StringBuilder totalGrowing = new StringBuilder(actual.getName()).append(delimiter).append("total_growing");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> totalGrowing.append(delimiter).append(data.getLivestockGrowth().getSumOfGrowth()));
            sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual))
                    .mapToInt(data -> data.getLivestockGrowth().getSumOfGrowth()).sum();
            totalGrowing.append(delimiter).append(sum);
            report.add(totalGrowing.toString());
            totalGrowing.delete(0, totalGrowing.length());

            StringBuilder death = new StringBuilder(actual.getName()).append(delimiter).append("death");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> death.append(delimiter).append(data.getLivestockDecrease().getDeath()));
            sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual))
                    .mapToInt(data -> data.getLivestockDecrease().getDeath()).sum();
            death.append(delimiter).append(sum);
            report.add(death.toString());
            death.delete(0, death.length());

            StringBuilder selling = new StringBuilder(actual.getName()).append(delimiter).append("selling");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> selling.append(delimiter).append(data.getLivestockDecrease().getSelling()));
            sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual))
                    .mapToInt(data -> data.getLivestockDecrease().getSelling()).sum();
            selling.append(delimiter).append(sum);
            report.add(selling.toString());
            selling.delete(0, selling.length());

            StringBuilder scrapping = new StringBuilder(actual.getName()).append(delimiter).append("reclassification_scrapping");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> scrapping.append(delimiter).append(data.getLivestockDecrease().getSumOfReclassificationAndScrapping()));
            sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual))
                    .mapToInt(data -> data.getLivestockDecrease().getSumOfReclassificationAndScrapping()).sum();
            scrapping.append(delimiter).append(sum);
            report.add(scrapping.toString());
            scrapping.delete(0, scrapping.length());

            StringBuilder totalDecreasing = new StringBuilder(actual.getName()).append(delimiter).append("total_decreasing");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> totalDecreasing.append(delimiter).append(data.getLivestockDecrease().getSumOfDecrease()));
            sum = livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual))
                    .mapToInt(data -> data.getLivestockDecrease().getSumOfDecrease()).sum();
            totalDecreasing.append(delimiter).append(sum);
            report.add(totalDecreasing.toString());
            totalDecreasing.delete(0, totalDecreasing.length());

            StringBuilder summary = new StringBuilder(actual.getName()).append(delimiter).append("summary");
            livestockChanges.stream().filter(data -> data.getAnimalUnit().equals(actual)).forEach(data -> summary.append(delimiter).append(data.getFullStock()));
            report.add(summary.toString());
            summary.delete(0, summary.length());
        }
        return report;
    }

    public String getDelimiter() {
        return delimiter;
    }
}

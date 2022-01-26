package breed;

import breed.cattle.Cattle;

import java.util.Set;
import java.util.TreeSet;

public class Breed {
    
    private Set<Cattle> herd = new TreeSet<>();

    public void addCattle(Cattle cattle) {
        validateCattle(cattle);
        herd.add(cattle);
    }

    private void validateCattle(Cattle cattle) {
        if (cattle == null) {
            throw new IllegalStateException ("Empty cattle object!");
        }
        if (isInHerd(cattle.getEarTagNumber())) {
            throw new IllegalArgumentException("There is a cattle in the herd with this ear tag number: " + cattle.getEarTagNumber());
        }
    }

    private boolean isInHerd(String earTagNumber) {
        return herd.stream().anyMatch(cattle -> cattle.getEarTagNumber().equals(earTagNumber));
    }

    public Set<Cattle> getHerd() {
        return Set.copyOf(herd);
    }
}

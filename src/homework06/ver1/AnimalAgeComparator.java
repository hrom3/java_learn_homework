package homework06.ver1;

import homework06.dto.Animal;
import java.util.Comparator;

public class AnimalAgeComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.compareTo(o2);
    }
}

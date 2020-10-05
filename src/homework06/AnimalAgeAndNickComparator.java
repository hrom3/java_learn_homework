package homework06;

import java.util.Comparator;

public class AnimalAgeAndNickComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        int result = o1.getAge() - o2.getAge();
        if (result != 0) {
            return result;
        }
        return o1.compareTo(o2);
    }
}

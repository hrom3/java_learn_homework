package homework06;

import homework06.dto.Animal;
import homework06.dto.Person;

import java.util.Comparator;

public class BigComparator<T extends IComparator> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.compareByAllFields(o2);
    }
}

package homework06;

import homework06.dto.Animal;

import java.util.Comparator;

public interface IComparator<T> {
    int compareByOneField(T o);
    int compareByAllFields(T o);
}

package homework06.ver2;

import java.util.Comparator;

public class BigComparator<T extends IComparator> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.compareByAllFields(o2);
    }
}

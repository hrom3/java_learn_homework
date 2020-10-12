package homework06.ver2;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class SortMy {
    public static <T> void sort(List<T> list, Comparator comparator) {
        if (list == null) {
            return;
        }
        if ( list.size() <= 1) {
            return;
        }
        T[] array =(T[]) list.toArray();
        boolean isSort = false;
        int i = 0;
        T tmp;

        while (!isSort) {
            isSort = true;
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSort = false;
                }
            }
            i++;
        }

        ListIterator iterator = list.listIterator();
        for (T e : array) {
            iterator.next();
            iterator.set(e);
        }
    }
}

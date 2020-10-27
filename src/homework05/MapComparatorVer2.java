package homework05;

import java.util.Comparator;
import java.util.Map;

public class MapComparatorVer2 <V extends String, E extends Integer>
        implements Comparator<Map.Entry<V, E>> {

    @Override
    public int compare(Map.Entry<V, E> o1, Map.Entry<V, E> o2) {
        return  o2.getValue().compareTo(o1.getValue());
    }
}


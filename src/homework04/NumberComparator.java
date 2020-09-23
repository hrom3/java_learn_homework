package homework04;

import java.util.Comparator;

public class NumberComparator implements Comparator<Number> {
    @Override
    public int compare(Number a, Number b) {
        double aDouble = a.doubleValue();
        double bDouble = b.doubleValue();
        if (aDouble - bDouble == 0) {
            return 0;
        }
        int aInt = a.intValue();
        int bInt = b.intValue();
        if (aDouble - bDouble > 1 || aDouble - bDouble < 1) {
            return aInt - bInt;
        }
        if (aDouble - bDouble > 0) {
            return 1;
        }
        return -1;
    }
}

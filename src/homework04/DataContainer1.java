package homework04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DataContainer1<T> {

    private T[] data;

    DataContainer1() {
        this.data = (T[]) Array.newInstance(getClass(), 10);
    }

    @Override
    public String toString() {
        return "DataContainer1{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    private int addData(T item) {
        int index = 0;

        return index;
    }


}




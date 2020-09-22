package homework04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

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

    public int addData(T item) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == null) {
                this.data[i] = item;
                return i;
            }
        }
        return -1;
    }

    public void bubbleSorter(Comparator<T> comparator) {
        for (int i = 0; i < this.data.length; i++) {
            for (int j = this.data.length - 1; j > i; j--) {
                if (comparator.compare(this.data[j],this.data[j - 1]) > 0) {
                    T temp = this.data[j - 1];
                    this.data[j - 1] = this.data[j];
                    this.data[j] = temp;
                }
            }
        }
    }
}




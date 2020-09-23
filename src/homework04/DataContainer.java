package homework04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T> {

    private T[] data;

    public DataContainer() {
        this.data = (T[]) Array.newInstance(getClass(), 1);
    }

    public DataContainer(T[] data) {
        this.data = data;
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
                this.data[i] = (T) item;
                return i;
            }
        }
        this.data = Arrays.copyOf(this.data,this.data.length + 1);
        this.data[this.data.length - 1] = item;
        return this.data.length - 1;
    }

    public T get(int index) {
        if (index < 0 || index >= this.data.length) {
            return null;
        }
        return data[index];
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




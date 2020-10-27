package homework04;

import homework02.ArraysMy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class DataContainer<T> {

    private T[] data;

//    public DataContainer() {
//        this.data = (T[]) Array.newInstance(getClass(), 1);
//    }

    public DataContainer(T[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataContainer1{" +
                "data=" + ArraysMy.toString(data) + '}';

    }

    public int addData(T item) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == null) {
                this.data[i] = (T) item;
                return i;
            }
        }
        this.data = Arrays.copyOf(this.data, this.data.length + 1);
        this.data[this.data.length - 1] = item;
        return this.data.length - 1;
    }

    public T get(int index) {
        if (index < 0 || index >= this.data.length) {
            return null;
        }
        return data[index];
    }

    public T[] getItems() {
        return data;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= this.data.length) {
            return false;
        }

        int newArrayLength = this.data.length - 1;
        if (newArrayLength > index) {
            System.arraycopy(this.data, index + 1, this.data, index, newArrayLength - index);
        }
        this.data = Arrays.copyOf(this.data, newArrayLength);
        return true;
    }

    public boolean delete(T item) {
        int index = getIndex(item);
        if (index < 0) {
            return false;
        }
        delete(index);
        return true;
    }

    private int getIndex(T item) {
        return getIndex(item, 0);
    }

    private int getIndex(T item, int index) {
        if (item == null) {
            for (int i = index; i < this.data.length; i++) {
                if (this.data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = index; i < this.data.length; i++) {
                if (item.equals(this.data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean deleteAllEntriesItems(T item) {
        int startIndex = 0;
        int index = getIndex(item, startIndex);

        if (index < 0) {
            return false;
        }
        while (index >= 0) {
            delete(index);
            startIndex = index;
            index = getIndex(item, startIndex);
        }

        return true;
    }

    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < this.data.length; i++) {
            for (int j = this.data.length - 1; j > i; j--) {
                if (this.data[j] == null) {
                    continue;
                }
                if (this.data[j - 1] == null) {
                    this.data[j - 1] = this.data[j];
                    this.data[j] = null;
                    continue;
                }
                if (comparator.compare(this.data[j], this.data[j - 1]) < 0) {
                    T temp = this.data[j - 1];
                    this.data[j - 1] = this.data[j];
                    this.data[j] = temp;
                }
            }
        }
    }
}




package homework04;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

public class DataContainer2 {

    @Override
    public String toString() {
        return "DataContainer2{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    private String[] data;

    public DataContainer2() {
        this.data = new String[10];
    }

}

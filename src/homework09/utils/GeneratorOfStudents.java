package homework09.utils;

import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;

public class GeneratorOfStudents {

    private static final Random RND = new Random();

        public <T> void randomCollection(Collection<T> collection, Supplier<T> supplier,
                                     int numberOfElements) {
        int arrListSize = collection.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
            collection.add(supplier.get());
        }
    }
}

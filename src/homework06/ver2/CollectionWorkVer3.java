package homework06.ver2;

import homework06.dto.Animal;
import homework06.dto.Person;
import utils.RandomMy;

import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;

public class CollectionWorkVer3 {
    private static final Random RND = new Random();

    public static Person generatePerson() {
//            return new Person(RandomMy.randomNextName(),
//                    RandomMy.randomNextString((rnd.nextInt(6) + 5)));
        return new Person(RandomMy.randomNextString((RND.nextInt(11) + 3)),
                RandomMy.randomNextString((RND.nextInt(6) + 5)));
    }

    public static Animal generateAnimal() {
//          return new Animal((rnd.nextInt(15) + 1),
//                   RandomMy.randomNextNick());
        return new Animal((RND.nextInt(15) + 1),
                RandomMy.randomNextString((RND.nextInt(11) + 5)));
    }

    public <T> void randomCollection(Collection<T> animalCollection, Supplier<T> supplier,
                                     int numberOfElements) {
        int arrListSize = animalCollection.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
            animalCollection.add(supplier.get());
        }
    }
}


package homework06;

import homework06.dto.Animal;
import homework06.dto.Person;
import utils.RandomMy;

import java.util.*;

public class CollectionWorkVer2 {
   private final Random rnd = new Random();

   public void animalRandomCollection(Collection<Animal> animalCollection,
                                       int numberOfElements) {
       int arrListSize = animalCollection.size();
       if (numberOfElements <= 0 || numberOfElements > 1_000_000
               || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
           System.out.println("Bad length of Arraylist");
       }
       for (int i = 0; i < numberOfElements; i++) {
//           animalArrayList.add(new Animal((rnd.nextInt(15) + 1),
//                   RandomMy.randomNextNick()));
           animalCollection.add(new Animal((rnd.nextInt(15) + 1),
                   RandomMy.randomNextString((rnd.nextInt(11) + 5))));
       }
   }

    public void personRandomCollection(Collection<Person> personCollection,
                                        int numberOfElements) {
        int arrListSize = personCollection.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
//            personArrayList.add(new Person(RandomMy.randomNextName(),
//                    RandomMy.randomNextString((rnd.nextInt(6) + 5))));
            personCollection.add(new Person(RandomMy.randomNextString((rnd.nextInt(11) + 3)),
                    RandomMy.randomNextString((rnd.nextInt(6) + 5))));
        }
    }


}


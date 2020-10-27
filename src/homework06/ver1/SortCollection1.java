package homework06.ver1;

import homework06.dto.Animal;

import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

public class SortCollection1<ITEM> {
    private final Random rnd = new Random();
     private Collection<ITEM> collect;

     public SortCollection1(Collection<ITEM> collection) {
        this.collect = collection;
    }

//    public void toAnimalRandomArrayList(ArrayList<ITEM> arrayList,
//                                        int numberOfElements) {
//        int arrListSize = arrayList.size();
//        if (numberOfElements <= 0 || numberOfElements > 1_000_000
//                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
//            System.out.println("Bad length of Arraylist");
//        }
//        for (int i = 0; i < numberOfElements; i++) {
////           arrayList.add(new Animal((rnd.nextInt(15) + 1),
////                   RandomMy.randomNextNick()));
//            boolean add;
//            add = arrayList.add(new ITEM((rnd.nextInt(15) + 1),
//                    RandomMy.randomNextString((rnd.nextInt(11) + 5))));
//        }
//    }

    private void sortAnimal(Comparator comparator, Collection<Animal> collection) {
        if (collection == null) {
            return;
        }
        Animal[] animalArray = collection.toArray(new Animal[collection.size()]);
        Animal tmp;
        for (int i = 0; i < animalArray.length - 1; i++) {
            for (int j = 0; j < animalArray.length - 1; j++) {
                if (comparator.compare(animalArray[j], animalArray[j + 1]) > 0) {
                    tmp = animalArray[j];
                    animalArray[j] = animalArray[j + 1];
                    animalArray[j + 1] = tmp;
                }
            }
        }
    }

//    private void sortPerson(Comparator comparator, Collection<Person> collection) {
//        if (collection == null) {
//            return;
//        }
//        Person[] personArray = collection.toArray(new Person[collection.size()]);
//        Person tmp;
//        for (int i = 0; i < personArray.length - 1; i++) {
//            for (int j = 0; j < personArray.length - 1; j++) {
//                if (comparator.compare(personArray[j], personArray[j + 1]) > 0) {
//                    tmp = personArray[j];
//                    personArray[j] = personArray[j + 1];
//                    personArray[j + 1] = tmp;
//                }
//            }
//        }
//    }
}

package homework06;

import utils.RandomMy;

import java.util.*;

public class CollectionWork {
   private final Random rnd = new Random();

   public void toAnimalRandomArrayList(ArrayList<Animal> animalArrayList,
                                       int numberOfElements) {
       int arrListSize = animalArrayList.size();
       if (numberOfElements <= 0 || numberOfElements > 1_000_000
               || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
           System.out.println("Bad length of Arraylist");
       }
       for (int i = 0; i < numberOfElements; i++) {
//           animalArrayList.add(new Animal((rnd.nextInt(15) + 1),
//                   RandomMy.randomNextNick()));
           animalArrayList.add(new Animal((rnd.nextInt(15) + 1),
                   RandomMy.randomNextString((rnd.nextInt(11) + 5))));
       }
   }

    public void toAnimalRandomLinkedList(LinkedList<Animal> animalLinkedList,
                                         int numberOfElements) {
        int arrListSize = animalLinkedList.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
            animalLinkedList.add(new Animal((rnd.nextInt(15) + 1),
                    RandomMy.randomNextString((rnd.nextInt(11) + 5))));
        }
    }

    public void toAnimalRandomHashSet(HashSet<Animal> animalHashSet,
                                      int numberOfElements) {
        int arrListSize = animalHashSet.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
            animalHashSet.add(new Animal((rnd.nextInt(15) + 1),
                    RandomMy.randomNextString((rnd.nextInt(11) + 5))));
        }
    }

    public void toAnimalRandomTreeSet(TreeSet<Animal> animalTreeSet,
                                      int numberOfElements) {
        int arrListSize = animalTreeSet.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
            animalTreeSet.add(new Animal((rnd.nextInt(15) + 1),
                    RandomMy.randomNextString((rnd.nextInt(11) + 5))));
        }
    }

    public void toPersonRandomArrayList(ArrayList<Person> personArrayList,
                                        int numberOfElements) {
        int arrListSize = personArrayList.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
//            personArrayList.add(new Person(RandomMy.randomNextName(),
//                    RandomMy.randomNextString((rnd.nextInt(6) + 5))));
            personArrayList.add(new Person(RandomMy.randomNextString((rnd.nextInt(11) + 3)),
                    RandomMy.randomNextString((rnd.nextInt(6) + 5))));
        }
    }

    public void toPersonRandomLinkedList(LinkedList<Person> personLinkedList,
                                        int numberOfElements) {
        int arrListSize = personLinkedList.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
            personLinkedList.add(new Person(RandomMy.randomNextString((rnd.nextInt(11) + 3)),
                    RandomMy.randomNextString((rnd.nextInt(6) + 5))));
        }
    }
    public void toPersonRandomHashSet(HashSet<Person> personHashSet,
                                        int numberOfElements) {
        int arrListSize = personHashSet.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
            personHashSet.add(new Person(RandomMy.randomNextString((rnd.nextInt(11) + 3)),
                    RandomMy.randomNextString((rnd.nextInt(6) + 5))));
        }
    }

    public void toPersonRandomTreeSet(TreeSet<Person> personTreeSet,
                                      int numberOfElements) {
        int arrListSize = personTreeSet.size();
        if (numberOfElements <= 0 || numberOfElements > 1_000_000
                || (numberOfElements + arrListSize) > Integer.MAX_VALUE) {
            System.out.println("Bad length of Arraylist");
        }
        for (int i = 0; i < numberOfElements; i++) {
            personTreeSet.add(new Person(RandomMy.randomNextString((rnd.nextInt(11) + 3)),
                    RandomMy.randomNextString((rnd.nextInt(6) + 5))));
        }
    }

}


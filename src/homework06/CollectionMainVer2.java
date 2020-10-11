package homework06;

import homework06.dto.Animal;
import homework06.dto.Person;
import utils.MethodRunningTime;

import java.util.*;

public class CollectionMainVer2 {
    public static void main(String[] args) {

        MethodRunningTime timeAll = new MethodRunningTime();
        CollectionWorkVer2 genCollection = new CollectionWorkVer2();
//        int collectionSize = 1_000_000;
        int collectionSize = 10000;

        // Создание коллекций
        LinkedList<Animal> animalLinkedList = new LinkedList<>();
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        HashSet<Animal> animalHashSet = new HashSet<>();
        TreeSet<Animal> animalTreeSet = new TreeSet<>();
        LinkedList<Person> personLinkedList = new LinkedList<>();
        ArrayList<Person> personArrayList = new ArrayList<>();
        HashSet<Person> personHashSet = new HashSet<>();
        TreeSet<Person> personTreeSet = new TreeSet<>();

        // Заполнение коллекций
        System.out.println("Заполнение коллекций Animal");

        MethodRunningTime timeGen1 = new MethodRunningTime();
        genCollection.animalRandomCollection(animalLinkedList, collectionSize);
        timeGen1.printRunningTime("Заполнение коллекции LinkedList "
                + collectionSize + " знач");

        timeGen1.setStartTime();
        genCollection.animalRandomCollection(animalArrayList, collectionSize);
        timeGen1.printRunningTime("Заполнение коллекции ArrayList "
                + collectionSize + " знач");

        timeGen1.setStartTime();
        genCollection.animalRandomCollection(animalHashSet, collectionSize);
        timeGen1.printRunningTime("Заполнение коллекции HashSet "
                + collectionSize + " знач");

        timeGen1.setStartTime();
        genCollection.animalRandomCollection(animalTreeSet, collectionSize);
        timeGen1.printRunningTime("Заполнение коллекции TreeSet "
                + collectionSize + " знач");

        System.out.println("Заполнение коллекций Person");

        MethodRunningTime timeGen2 = new MethodRunningTime();
        genCollection.personRandomCollection(personLinkedList, collectionSize);
        timeGen1.printRunningTime("Заполнение коллекции LinkedList "
                + collectionSize + " знач");

        timeGen2.setStartTime();
        genCollection.personRandomCollection(personArrayList, collectionSize);
        timeGen2.printRunningTime("Заполнение коллекции ArrayList "
                + collectionSize + " знач");

        timeGen2.setStartTime();
        genCollection.personRandomCollection(personHashSet, collectionSize);
        timeGen1.printRunningTime("Заполнение коллекции HashSet "
                + collectionSize + " знач");

        timeGen2.setStartTime();
        genCollection.personRandomCollection(personTreeSet, collectionSize);
        timeGen1.printRunningTime("Заполнение коллекции TreeSet "
                + collectionSize + " знач");

//        for (Animal animal : animalLinkedList) {
//            System.out.println(animal);
//        }
//        System.out.println("/____________/");
//
//        for (Animal animal : animalArrayList) {
//            System.out.println(animal);
//        }
//        System.out.println("/____________/");
//
//        for (Animal animal : animalHashSet) {
//            System.out.println(animal);
//        }
//        System.out.println("/____________/");
//
//        for (Animal animal : animalTreeSet) {
//            System.out.println(animal);
//        }
//        System.out.println("/____________/");

        System.out.println("Размер \"animalLinkedList\" = " + animalLinkedList.size());
        System.out.println("/____________/");
        System.out.println("Размер \"animalsArrayList\" = " +animalArrayList.size());
        System.out.println("/____________/");
        System.out.println("Размер \"animalHashSet\" = " + animalHashSet.size());
        System.out.println("/____________/");
        System.out.println("Размер \"animalTreeSet\" = " + animalTreeSet.size());
        System.out.println("/____________/");


        // Сортировка коллекций
        System.out.println("Сортировка коллекций Animal");

        MethodRunningTime timeGen3 = new MethodRunningTime();
        animalLinkedList.sort(new BigComparator<>());
        timeGen3.printRunningTime("Сортировка коллекции LinkedList");

        timeGen3.setStartTime();
        animalArrayList.sort(new LowComparator<>());
        timeGen3.printRunningTime("Сортировка коллекции ArrayList");

        timeGen3.setStartTime();
        TreeSet<Animal> animalTreeSet1 = new TreeSet<>(new LowComparator<>());

        animalTreeSet1.addAll(animalArrayList);
        timeGen3.printRunningTime("Заполнение коллекции TreeSet c сортировкой другим компаратором");

        System.out.println("Размер \"animalTreeSet1\" = " + animalTreeSet1.size());
        System.out.println("/____________/");

        // Сортировка коллекций
        System.out.println("Сортировка коллекций Person");

        MethodRunningTime timeGen4 = new MethodRunningTime();
        personLinkedList.sort(new BigComparator<>());
        timeGen4.printRunningTime("Сортировка коллекции LinkedList");

        timeGen4.setStartTime();
        personLinkedList.sort(new LowComparator<>());
        timeGen4.printRunningTime("Сортировка коллекции LinkedList");

        timeGen4.setStartTime();
        TreeSet<Person> personTreeSet1 = new TreeSet<>(new BigComparator<>());

        personTreeSet1.addAll(personArrayList);
        timeGen4.printRunningTime("Заполнение коллекции TreeSet c сортировкой другим компаратором");

        System.out.println("Размер \"personTreeSet1\" = " + personTreeSet1.size());
        System.out.println("/____________/");

        timeAll.printRunningTime("Всего времени");

//        for (Animal animal : animalsArrayList) {
//            System.out.println(animal);
//        }
//        System.out.println("/____________/");
//        animalsArrayList.sort(new AnimalAgeAndNickComparator());
//        for (Animal animal : animalsArrayList) {
//            System.out.println(animal);
//        }
//
//        for (Person person : personArrayList) {
//            System.out.println(person);
//        }
//        System.out.println("/____________/");
//        personArrayList.sort(new PasswordLengthAndNickComparator());
//        for (Person person : personArrayList) {
//            System.out.println(person);
//        }
        ArrayList<Animal> animalArrayList1 = new ArrayList<>();
        animalArrayList1.addAll(animalArrayList);

        long startTime8 = System.currentTimeMillis();
        for (int i1 = 0; i1 < animalArrayList.size(); i1++) {
            animalArrayList.get(i1).toString();
        }
        long endTime8 = System.currentTimeMillis();
        long startTime9 = System.currentTimeMillis();
        for (int i1 = animalArrayList.size() - 1; i1 >= 0; i1--) {
            animalArrayList.remove(i1);
        }
        System.out.println("Размер \"animalsArrayList\" = " + animalArrayList.size());
        System.out.println("/____________/");
//        for (Animal animal : animalsArrayList) {
//            animal.toString();
//        }
        System.out.println("/____________1/");
        long endTime9 = System.currentTimeMillis();
        System.out.println("Total execution time of operation " + 9 + " : "
                + ((endTime8-startTime8) / 1000.) + "s" + " of operation " + 10 + " : "
                + ((endTime9-startTime9) / 1000.) + "s" );

        long startTime10 = System.currentTimeMillis();
        Iterator iterator = animalArrayList1.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        System.out.println("/____________2/");
        long endTime10 = System.currentTimeMillis();


        long startTime11 = System.currentTimeMillis();
        Iterator iterator1 = animalArrayList1.iterator();
        while (iterator1.hasNext()) {
            iterator1.next();
            iterator1.remove();
        }

        System.out.println("/____________2/");
        long endTime11 = System.currentTimeMillis();
        System.out.println("Total execution time of operation " + 11 + " : "
                + ((endTime10-startTime10) / 1000.) + "s" + " of operation " + 12 + " : "
                + ((endTime11-startTime11) / 1000.) + "s" );


        for (Animal animal : animalArrayList1) {
            System.out.println(animal);
        }
    }




}


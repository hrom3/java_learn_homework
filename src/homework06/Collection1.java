package homework06;

import homework06.dto.Animal;
import homework06.dto.Person;

import java.util.*;

public class Collection1 {
    public static void main(String[] args) {
        long startTimeAll = System.currentTimeMillis();

        CollectionWork arrList = new CollectionWork();
        LinkedList<Animal> animalLinkedList = new LinkedList<>();
        ArrayList<Animal> animalsArrayList;
        HashSet<Animal> animalHashSet;
        TreeSet<Animal> animalTreeSet;
        LinkedList<Person> personLinkedList = new LinkedList<>();
        ArrayList<Person> personArrayList;
        HashSet<Person> personHashSet;
        TreeSet<Person> personTreeSet;

        long startTime = System.currentTimeMillis();

        arrList.toAnimalRandomLinkedList(animalLinkedList, 1_000_000);

        long endTime = System.currentTimeMillis();

        animalsArrayList = new ArrayList<>(animalLinkedList);
        animalHashSet = new HashSet<>(animalLinkedList);
        animalTreeSet = new TreeSet<>(animalLinkedList);

        long startTime1 = System.currentTimeMillis();

        arrList.toPersonRandomLinkedList(personLinkedList, 1_000_000);

        long endTime1 = System.currentTimeMillis();

        personArrayList = new ArrayList<>(personLinkedList);
        personHashSet = new HashSet<>(personLinkedList);
        personTreeSet = new TreeSet<>(personLinkedList);

//        for (Animal animal : animalLinkedList) {
//            System.out.println(animal);
//        }
//        System.out.println("/____________/");
//
//        for (Animal animal : animalsArrayList) {
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
        System.out.println("Размер \"animalsArrayList\" = " +animalsArrayList.size());
        System.out.println("/____________/");
        System.out.println("Размер \"animalHashSet\" = " + animalHashSet.size());
        System.out.println("/____________/");
        System.out.println("Размер \"animalTreeSet\" = " + animalTreeSet.size());
        System.out.println("/____________/");
        System.out.println("Total execution time of operation " + 1 + " : "
                + ((endTime-startTime) / 1000.) + "s");
        System.out.println("Total execution time of operation " + 2 + " : "
                + ((endTime1-startTime1) / 1000.) + "s");

        long endTimeAll1 = System.currentTimeMillis();

        animalLinkedList.sort(new AnimalAgeComparator());
        animalLinkedList.sort(new AnimalAgeAndNickComparator());
        animalsArrayList.sort(new AnimalAgeComparator());
        animalsArrayList.sort(new AnimalAgeAndNickComparator());
        TreeSet<Animal> animalTreeSet1 = new TreeSet<>(new AnimalAgeComparator());
        TreeSet<Animal> animalTreeSet2 = new TreeSet<>(new AnimalAgeAndNickComparator());
        TreeSet<Animal> animalTreeSet3 = new TreeSet<>(new AnimalAgeComparator());
        TreeSet<Animal> animalTreeSet4 = new TreeSet<>(new AnimalAgeAndNickComparator());
        animalTreeSet1.addAll(animalHashSet);
        animalTreeSet2.addAll(animalHashSet);
        animalTreeSet3.addAll(animalTreeSet);
        animalTreeSet4.addAll(animalTreeSet);

        personLinkedList.sort(new PasswordLengthComparator());
        personLinkedList.sort(new PasswordLengthAndNickComparator());
        personArrayList.sort(new PasswordLengthComparator());
        personArrayList.sort(new PasswordLengthAndNickComparator());

        long endTimeAll = System.currentTimeMillis();
        System.out.println("Total execution time of operations : "
                + ((endTimeAll-startTimeAll) / 1000.) + "s (Time of sorting "
                + (endTimeAll-endTimeAll1) + "ms)");

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
        animalArrayList1.addAll(animalsArrayList);

        long startTime8 = System.currentTimeMillis();
        for (int i1 = 0; i1 < animalsArrayList.size(); i1++) {
            animalsArrayList.get(i1).toString();
        }
        long endTime8 = System.currentTimeMillis();
        long startTime9 = System.currentTimeMillis();
        for (int i1 = animalsArrayList.size() - 1; i1 >= 0; i1--) {
            animalsArrayList.remove(i1);
        }
        System.out.println("Размер \"animalsArrayList\" = " +animalsArrayList.size());
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


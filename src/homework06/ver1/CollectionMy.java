package homework06.ver1;

import homework06.dto.Animal;
import homework06.dto.Person;

import java.util.*;

public class CollectionMy {

    public static void main(String[] args) {
        long startTimeAll = System.currentTimeMillis();

        Comparator<Animal> comparatorAnimalAllFields = new AnimalAgeAndNickComparator();
        Comparator<Animal> comparatorAnimal = new AnimalAgeComparator();
        Comparator<Person> comparatorPersonAllFields = new PasswordLengthAndNickComparator();
        Comparator<Person> comparatorPerson = new PasswordLengthComparator();

        CollectionWork arrList = new CollectionWork();
        LinkedList<Animal> animalLinkedList = new LinkedList<>();
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        HashSet<Animal> animalHashSet = new HashSet<>();
        TreeSet<Animal> animalTreeSet = new TreeSet<>();

        LinkedList<Person> personLinkedList = new LinkedList<>();
        ArrayList<Person> personArrayList = new ArrayList<>();
        HashSet<Person> personHashSet = new HashSet<>();
        TreeSet<Person> personTreeSet = new TreeSet<>();

        long startTimeOfFilling = System.currentTimeMillis();

        arrList.toAnimalRandomLinkedList(animalLinkedList, 1_000_000);

        long endTimeOfFilling = System.currentTimeMillis();


        arrList.toAnimalRandomArrayList(animalArrayList, 1_000_000);
        arrList.toAnimalRandomHashSet(animalHashSet, 1_000_000);
        arrList.toAnimalRandomTreeSet(animalTreeSet, 1_000_000);
        arrList.toPersonRandomLinkedList(personLinkedList, 1_000_000);
        arrList.toPersonRandomArrayList(personArrayList, 1_000_000);
        arrList.toPersonRandomHashSet(personHashSet, 1_000_000);
        arrList.toPersonRandomTreeSet(personTreeSet, 1_000_000);
        LinkedList<Animal> animalLinkedList1 = new LinkedList<>(animalArrayList);

        long startTimeOfSorting = System.currentTimeMillis();

        animalLinkedList.sort(comparatorAnimalAllFields);

        long endTimeOfSorting = System.currentTimeMillis();

        long startTimeOfSortingMy = System.currentTimeMillis();

//        sortAnimal(comparatorAnimalAllFields, animalLinkedList1);

        long endTimeOfSortingMy = System.currentTimeMillis();

        animalLinkedList.sort(comparatorAnimalAllFields);
        animalArrayList.sort(comparatorAnimal);
        animalArrayList.sort(comparatorAnimalAllFields);
        animalTreeSet = new TreeSet<>(comparatorAnimal);
        animalTreeSet = new TreeSet<>(comparatorAnimalAllFields);
        animalTreeSet = new TreeSet<>(comparatorAnimal);
        animalTreeSet = new TreeSet<>(comparatorAnimalAllFields);

        personLinkedList.sort(comparatorPerson);
        personLinkedList.sort(comparatorPersonAllFields);
        personArrayList.sort(comparatorPerson);
        personArrayList.sort(comparatorPersonAllFields);
        personTreeSet = new TreeSet<>(comparatorPerson);
        personTreeSet = new TreeSet<>(comparatorPersonAllFields);
        personTreeSet = new TreeSet<>(comparatorPerson);
        personTreeSet = new TreeSet<>(comparatorPersonAllFields);

        long startTimeOfIterating = System.currentTimeMillis();

        for (Animal animal : animalLinkedList) {
            System.out.println(animal);
        }

        System.out.println("/____________/");

        Iterator<Animal> iterator1 = animalLinkedList.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("/____________/");

        long endTimeOfIterating = System.currentTimeMillis();

        ArrayList<Animal> animalArrayList1 = new ArrayList<>(animalArrayList);

        long startTimeOfIteratingFor = System.currentTimeMillis();
        for (int i1 = 0; i1 < animalArrayList.size(); i1++) {
            System.out.println(animalArrayList.get(i1));
        }
        long endTimeOfIteratingFor = System.currentTimeMillis();

        long startTimeOfRemoveIter = System.currentTimeMillis();
        Iterator<Animal> iterator = animalArrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        long endTimeOfRemoveIter = System.currentTimeMillis();

        long startTimeOfRemoveFor = System.currentTimeMillis();
        for (int i1 = animalArrayList1.size() - 1; i1 >= 0; i1--) {
            animalArrayList1.remove(i1);
        }
        long endTimeOfRemoveFor = System.currentTimeMillis();

        long endTimeAll = System.currentTimeMillis();

        System.out.println("/____________/");
        System.out.println("Операция: Заполнение коллекции. " +
                "Заняла: " + (endTimeOfFilling - startTimeOfFilling) + " мс");
        System.out.println("Операция: Сортировка коллекции средствами jdk. " +
                "Заняла: " + (endTimeOfSorting - startTimeOfSorting) + " мс");
        System.out.println("Операция: Сортировка коллекции моим методом. " +
                "Заняла: " + (endTimeOfSortingMy - startTimeOfSortingMy) + " мс");
        System.out.println("Операция: Итерирование коллекции при помощи iterator. " +
                "Заняла: " + (endTimeOfIterating - startTimeOfIterating) + " мс");
        System.out.println("Операция: Итерирование коллекции при помощи for. " +
                "Заняла: " + (endTimeOfIteratingFor - startTimeOfIteratingFor) + " мс");
        System.out.println("Операция: Удаление коллекции при помощи iterator. " +
                "Заняла: " + (endTimeOfRemoveIter - startTimeOfRemoveIter) + " мс");
        System.out.println("Операция: Удаление коллекции при помощи for. " +
                "Заняла: " + (endTimeOfRemoveFor - startTimeOfRemoveFor) + " мс");

        System.out.println("Total execution time of operations : "
                + ((endTimeAll - startTimeAll) / 1000.) + "s");

    }

    private static void sortAnimal(Comparator comparator, Collection<Animal> list) {
        if (list == null) {
            return;
        }
        Animal[] array = list.toArray(new Animal[list.size()]);
        Animal tmp;

        boolean isSort = false;
        int i = 0;

        while (!isSort) {
            isSort = true;
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSort = false;
                }
            }
            i++;
        }

        ListIterator iterator = (ListIterator) list.iterator();
        for (Animal e : array) {
            iterator.next();
            iterator.set(e);
        }
    }

    private static void sortPerson(Comparator comparator, Collection<Person> list) {
        if (list == null) {
            return;
        }
        Person[] array = list.toArray(new Person[list.size()]);
        Person tmp;
        boolean isSort = false;
        int i = 0;

        while (!isSort) {
            isSort = true;
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSort = false;
                }
            }
            i++;
        }

        ListIterator iterator = (ListIterator) list.iterator();
        for (Person e : array) {
            iterator.next();
            iterator.set(e);
        }
    }
}

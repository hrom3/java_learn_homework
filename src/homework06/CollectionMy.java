package homework06;

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

        long startTimeOfSorting = System.currentTimeMillis();

        animalLinkedList.sort(comparatorAnimal);

        long endTimeOfSorting = System.currentTimeMillis();

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
//
//        Iterator<Animal> iterator1 = animalArrayList.iterator();
//        while (iterator1.hasNext()) {
//            System.out.println(iterator1.next());
//        }

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
        System.out.println("Операция: Сортировка коллекции. " +
                "Заняла: " + (endTimeOfSorting - startTimeOfSorting) + " мс");
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

//    public static <V> void sort(List list, Comparator<Animal> comparator){
//        V tmp;
//        for (int i = 0; i < container.data.length - 1; i++) {
//            for (int j = 0; j < container.data.length - 1; j++) {
//                if (comparator.compare(container.data[j], container.data[j + 1]) > 0) {
//                    tmp = container.data[j];
//                    container.data[j] = container.data[j + 1];
//                    container.data[j + 1] = tmp;
//                }
//            }
//        }
//    }
//
//    public void sort(Comparator comparator){
//        T tmp;
//        for (int i = 0; i < this.data.length - 1; i++) {
//            for (int j = 0; j < this.data.length - 1; j++) {
//                if (comparator.compare(this.data[j], this.data[j + 1]) > 0) {
//                    tmp = this.data[j];
//                    this.data[j] = this.data[j + 1];
//                    this.data[j + 1] = tmp;
//                }
//            }
//        }
//    }
//
//    public static <V extends Comparable> void sort(DataContainer<V> container){
//        V tmp;
//        for (int i = 0; i < container.data.length - 1; i++) {
//            for (int j = 0; j < container.data.length - 1; j++) {
//                if (container.data[j].compareTo(container.data[j + 1]) > 0) {
//                    tmp = container.data[j];
//                    container.data[j] = container.data[j + 1];
//                    container.data[j + 1] = tmp;
//                }
//            }
//        }
//
//    }
}

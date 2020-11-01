package homework06.ver2;

import homework06.dto.Animal;
import homework06.dto.Person;
import homework06.utils.MethodRunningTime;

import java.util.*;

public class CollectionMainVer3 {
    public static void main(String[] args) {
        ArrayList<MethodRunningTime> listOfTimes = new ArrayList<>();
        MethodRunningTime timeAll = new MethodRunningTime("Все операции");
        CollectionWorkVer3 genCollection = new CollectionWorkVer3();
 //       int collectionSize = 1_000_000;
       int collectionSize = 100_000;

        // Создание коллекций
        MethodRunningTime timeGenAll = new MethodRunningTime("Заполнение всех коллекций "
                + collectionSize + " знач");

        LinkedList<Animal> animalLinkedList = new LinkedList<>();
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        HashSet<Animal> animalHashSet = new HashSet<>();
        TreeSet<Animal> animalTreeSet = new TreeSet<>();
        LinkedList<Person> personLinkedList = new LinkedList<>();
        ArrayList<Person> personArrayList = new ArrayList<>();
        HashSet<Person> personHashSet = new HashSet<>();
        TreeSet<Person> personTreeSet = new TreeSet<>();

        // Заполнение коллекций
        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции LinkedList" +
                " элементами Animal " + collectionSize + " знач");
        genCollection.randomCollection(animalLinkedList, CollectionWorkVer3::
                generateAnimal, collectionSize);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции ArrayList" +
                " элементами Animal " + collectionSize + " знач");
        genCollection.randomCollection(animalArrayList, CollectionWorkVer3::
                generateAnimal, collectionSize);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции HashSet " +
                "элементами Animal " + collectionSize + " знач");
        genCollection.randomCollection(animalHashSet, CollectionWorkVer3::
                generateAnimal, collectionSize);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции TreeSet " +
                "элементами Animal " + collectionSize + " знач");
        genCollection.randomCollection(animalTreeSet, CollectionWorkVer3::
                generateAnimal, collectionSize);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции LinkedList" +
                " элементами Person " + collectionSize + " знач");
        genCollection.randomCollection(personLinkedList, CollectionWorkVer3::
                generatePerson, collectionSize);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции ArrayList " +
                "элементами Person " + collectionSize + " знач");
        genCollection.randomCollection(personArrayList, CollectionWorkVer3::
                generatePerson, collectionSize);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции HashSet" +
                " элементами Person " + collectionSize + " знач");
        genCollection.randomCollection(personHashSet, CollectionWorkVer3::
                generatePerson, collectionSize);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции TreeSet" +
                " элементами Person " + collectionSize + " знач");
        genCollection.randomCollection(personTreeSet, CollectionWorkVer3::
                generatePerson, collectionSize);
        addEndOperationTimeToLastItemInList(listOfTimes);

        timeGenAll.setEndTime();
        listOfTimes.add(timeGenAll);

        // Копирование коллекций перед сортировкой
        LinkedList<Animal> animalLinkedList1 = new LinkedList<>(animalLinkedList);
        ArrayList<Animal> animalArrayList1 = new ArrayList<>(animalArrayList);
        HashSet<Animal> animalHashSet1 = new HashSet<>(animalHashSet);
        LinkedList<Person> personLinkedList1 = new LinkedList<>(personLinkedList);
        ArrayList<Person> personArrayList1 = new ArrayList<>(personArrayList);
        HashSet<Person> personHashSet1 = new HashSet<>(personHashSet);

        // Сортировка коллекций
        MethodRunningTime timeSortAll = new MethodRunningTime("Сортировка всех коллекции");

        addNewOperationTimeToList(listOfTimes, "Сортировка коллекции LinkedList" +
                " c элементами Animal средствами JDK ");
        animalLinkedList1.sort(new BigComparator<>());
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Сортировка коллекции ArrayList" +
                " c элементами Animal средствами JDK ");
        animalArrayList1.sort(new BigComparator<>());
        addEndOperationTimeToLastItemInList(listOfTimes);

        // Коллекции TreeSet сортируются при вставке с помощью compareTo
        // можно отсориторовать с помощью другого компаратора
        // Коллекции HashSet сортируются при вставке по HashCode,
        // который переопредлен в классе
        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции TreeSet" +
                " c элементами Animal c сортировкой LowComparator");
        TreeSet<Animal> animalTreeSet1 = new TreeSet<>(new LowComparator<>());

        animalTreeSet1.addAll(animalArrayList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Сортировка коллекции LinkedList" +
                " c элементами Person");
        personLinkedList1.sort(new BigComparator<>());
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Сортировка коллекции ArrayList" +
                " c элементами Person");
        personArrayList1.sort(new BigComparator<>());
        addEndOperationTimeToLastItemInList(listOfTimes);

        // Коллекции TreeSet сортируются при вставке с помощью compareTo
        // можно отсориторовать с помощью другого компаратора
        // Коллекции HashSet сортируются при вставке по HashCode,
        // который переопредлен в классе
        addNewOperationTimeToList(listOfTimes, "Заполнение коллекции TreeSet c " +
                " c элементами Person сортировкой LowComparator");
        TreeSet<Person> personTreeSet1 = new TreeSet<>(new LowComparator<>());

        personTreeSet1.addAll(personArrayList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        // Сортировка коллекций пузырьком
//        addNewOperationTimeToList(listOfTimes, "Сортировка коллекции LinkedList" +
//                " c элементами Animal пузырьковой сортировкой");
//        SortMy.sort(animalArrayList, new BigComparator<Animal>());
//        addEndOperationTimeToLastItemInList(listOfTimes);
//
//        addNewOperationTimeToList(listOfTimes, "Сортировка коллекции ArrayList" +
//                " c элементами Animal пузырьковой сортировкой");
//        SortMy.sort(animalLinkedList, new BigComparator<Animal>());
//        addEndOperationTimeToLastItemInList(listOfTimes);
//
//        addNewOperationTimeToList(listOfTimes, "Сортировка коллекции LinkedList" +
//                " c элементами Person пузырьковой сортировкой");
//        SortMy.sort(personLinkedList, new BigComparator<Animal>());
//        addEndOperationTimeToLastItemInList(listOfTimes);
//
//        addNewOperationTimeToList(listOfTimes, "Сортировка коллекции ArrayList" +
//                " c элементами Person пузырьковой сортировкой");
//        SortMy.sort(personArrayList, new BigComparator<Animal>());
//       addEndOperationTimeToLastItemInList(listOfTimes);

        timeSortAll.setEndTime();
        listOfTimes.add(timeSortAll);

        // Итерирование коллекций
        MethodRunningTime timeIterAll = new MethodRunningTime("Итерирование всех коллекций " +
                "разными способами");

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции LinkedList" +
                " c элементами Animal средствами JDK");
        iteratorJDK(animalLinkedList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции ArrayList" +
                " c элементами Animal средствами JDK");
        iteratorJDK(animalArrayList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции HashSet" +
                " c элементами Animal средствами JDK");
        iteratorJDK(animalHashSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции TreeSet"
                + " c элементами Animal средствами JDK");
        iteratorJDK(animalTreeSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции LinkedList"
                + " c элементами Person средствами JDK");
        iteratorJDK(personLinkedList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции ArrayList"
                + " c элементами Person средствами JDK");
        iteratorJDK(personArrayList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции HashSet"
                + " c элементами Person средствами JDK");
        iteratorJDK(personHashSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции TreeSet"
                + " c элементами Person средствами JDK");
        iteratorJDK(personTreeSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции LinkedList" +
                " c элементами Animal другим способом");
        myIteratorFor(animalLinkedList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции ArrayList" +
                " c элементами Animal другим способом");
        myIteratorFor(animalArrayList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции HashSet" +
                " c элементами Animal другим способом");
        myIteratorFor(animalHashSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции TreeSet" +
                " c элементами Animal другим способом");
        myIteratorFor(animalTreeSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции LinkedList" +
                " c элементами Person другим способом");
        myIteratorFor(personLinkedList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции ArrayList" +
                " c элементами Person другим способом");
        myIteratorFor(personArrayList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции HashSet" +
                " c элементами Person другим способом");
        myIteratorFor(personHashSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Итерирование коллекции TreeSet" +
                " c элементами Person другим способом");
        myIteratorFor(personTreeSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        timeIterAll.setEndTime();
        listOfTimes.add(timeIterAll);

        // Удаление коллекций
        MethodRunningTime timeDelAll = new MethodRunningTime("Удаление всех коллекций " +
                "разными способами");

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции LinkedList" +
                " c элементами Animal средствами JDK");
        deleteIteratorJDK(animalLinkedList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции ArrayList" +
                " c элементами Animal средствами JDK");
        deleteIteratorJDK(animalArrayList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции HashSet" +
                " c элементами Animal средствами JDK");
        deleteIteratorJDK(animalHashSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции TreeSet" +
                " c элементами Animal средствами JDK");
        deleteIteratorJDK(animalTreeSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции LinkedList" +
                " c элементами Person средствами JDK");
        deleteIteratorJDK(personLinkedList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции ArrayList" +
                " c элементами Person средствами JDK");
        deleteIteratorJDK(personArrayList);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции HashSet" +
                " c элементами Person средствами JDK");
        deleteIteratorJDK(personHashSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции TreeSet" +
                " c элементами Person средствами JDK");
        deleteIteratorJDK(personTreeSet);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции LinkedList" +
                " c элементами Animal другим способом");
        myDeleteFor(animalLinkedList1);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции ArrayList" +
                " c элементами Animal другим способом");
        myDeleteFor(animalArrayList1);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции HashSet" +
                " c элементами Animal другим способом");
        myDeleteFor(animalHashSet1);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции TreeSet" +
                " c элементами Animal другим способом");
        myDeleteFor(animalTreeSet1);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции LinkedList" +
                " c элементами Person другим способом");
        myDeleteFor(personLinkedList1);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции ArrayList" +
                " c элементами Person другим способом");
        myDeleteFor(personArrayList1);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции HashSet" +
                " c элементами Person другим способом");
        myDeleteFor(personHashSet1);
        addEndOperationTimeToLastItemInList(listOfTimes);

        addNewOperationTimeToList(listOfTimes, "Удаление коллекции TreeSet" +
                " c элементами Person другим способом");
        myDeleteFor(personTreeSet1);
        addEndOperationTimeToLastItemInList(listOfTimes);

        timeDelAll.setEndTime();
        listOfTimes.add(timeDelAll);

        timeAll.setEndTime();
        listOfTimes.add(timeAll);
        iteratorJDK(listOfTimes);
        listOfTimes.clear();
    }


    private static <T> void myIteratorFor(Collection<T> collection) {

        T[] array = (T[]) collection.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static <T> void iteratorJDK(Collection<T> collection) {

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static <T> void myDeleteFor(Collection<T> collection) {

        T[] array = (T[]) collection.toArray();
        for (int i = 0; i < array.length; i++) {
            collection.remove(array[i]);
        }
    }

    private static <T> void deleteIteratorJDK(Collection<T> collection) {

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public static void addNewOperationTimeToList(List<MethodRunningTime> list, String operationName) {
        list.add(new MethodRunningTime(operationName));
    }

    public static void addEndOperationTimeToLastItemInList(List<MethodRunningTime> list) {
        list.get(list.size() - 1).setEndTime();
    }



}


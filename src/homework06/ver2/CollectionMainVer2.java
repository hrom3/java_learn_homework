package homework06.ver2;

import homework06.dto.Animal;
import homework06.dto.Person;
import utils.MethodRunningTime;

import java.util.*;

public class CollectionMainVer2 {
    public static void main(String[] args) {
        ArrayList<String> listOfTimes = new ArrayList<>();

        MethodRunningTime timeAll = new MethodRunningTime();
        CollectionWorkVer2 genCollection = new CollectionWorkVer2();
//        int collectionSize = 1_000_000;
        int collectionSize = 100_000;

        // Создание коллекций

        MethodRunningTime timeGenAll = new MethodRunningTime();

        LinkedList<Animal> animalLinkedList = new LinkedList<>();
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        HashSet<Animal> animalHashSet = new HashSet<>();
        TreeSet<Animal> animalTreeSet = new TreeSet<>();
        LinkedList<Person> personLinkedList = new LinkedList<>();
        ArrayList<Person> personArrayList = new ArrayList<>();
        HashSet<Person> personHashSet = new HashSet<>();
        TreeSet<Person> personTreeSet = new TreeSet<>();

        // Заполнение коллекций
        listOfTimes.add("Заполнение коллекций Animal");

        MethodRunningTime timeGen1 = new MethodRunningTime();
        genCollection.animalRandomCollection(animalLinkedList, collectionSize);
        listOfTimes.add(timeGen1.toString("Заполнение коллекции LinkedList "
                + collectionSize + " знач"));

        timeGen1.setStartTime();
        genCollection.animalRandomCollection(animalArrayList, collectionSize);
        listOfTimes.add(timeGen1.toString("Заполнение коллекции ArrayList "
                + collectionSize + " знач"));

        timeGen1.setStartTime();
        genCollection.animalRandomCollection(animalHashSet, collectionSize);
        listOfTimes.add(timeGen1.toString("Заполнение коллекции HashSet "
                + collectionSize + " знач"));

        timeGen1.setStartTime();
        genCollection.animalRandomCollection(animalTreeSet, collectionSize);
        listOfTimes.add(timeGen1.toString("Заполнение коллекции TreeSet "
                + collectionSize + " знач"));

        listOfTimes.add("Заполнение коллекций Person");

        timeGen1.setStartTime();
        genCollection.personRandomCollection(personLinkedList, collectionSize);
        listOfTimes.add(timeGen1.toString("Заполнение коллекции LinkedList "
                + collectionSize + " знач"));

        timeGen1.setStartTime();
        genCollection.personRandomCollection(personArrayList, collectionSize);
        listOfTimes.add(timeGen1.toString("Заполнение коллекции ArrayList "
                + collectionSize + " знач"));

        timeGen1.setStartTime();
        genCollection.personRandomCollection(personHashSet, collectionSize);
        listOfTimes.add(timeGen1.toString("Заполнение коллекции HashSet "
                + collectionSize + " знач"));

        timeGen1.setStartTime();
        genCollection.personRandomCollection(personTreeSet, collectionSize);
        listOfTimes.add(timeGen1.toString("Заполнение коллекции TreeSet "
                + collectionSize + " знач"));

        listOfTimes.add("");

        listOfTimes.add(timeGenAll.toString("Заполнение всех коллекций "
                + collectionSize + " знач"));

        listOfTimes.add("/____________/");

        // Копирование коллекций перед сортировкой
        LinkedList<Animal> animalLinkedList1 = new LinkedList<>(animalLinkedList);
        ArrayList<Animal> animalArrayList1 = new ArrayList<>(animalArrayList);
        HashSet<Animal> animalHashSet1 = new HashSet<>(animalHashSet);
        LinkedList<Person> personLinkedList1 = new LinkedList<>(personLinkedList);
        ArrayList<Person> personArrayList1 = new ArrayList<>(personArrayList);
        HashSet<Person> personHashSet1 = new HashSet<>(personHashSet);

        // Сортировка коллекций
        listOfTimes.add("Сортировка коллекций Animal средствами JDK");

        MethodRunningTime timeSortAll = new MethodRunningTime();

        MethodRunningTime timeSort1 = new MethodRunningTime();
        animalLinkedList1.sort(new BigComparator<>());
        listOfTimes.add(timeSort1.toString("Сортировка коллекции LinkedList"));

        timeSort1.setStartTime();
        animalArrayList1.sort(new BigComparator<>());
        listOfTimes.add(timeSort1.toString("Сортировка коллекции ArrayList"));

        // Коллекции TreeSet сортируются при вставке с помощью compareTo
        // можно отсориторовать с помощью другого компаратора
        // Коллекции HashSet сортируются при вставке по HashCode,
        // который переопредлен в классе
        timeSort1.setStartTime();
        TreeSet<Animal> animalTreeSet1 = new TreeSet<>(new LowComparator<>());

        animalTreeSet1.addAll(animalArrayList);
        listOfTimes.add(timeSort1.toString("Заполнение коллекции TreeSet c " +
                "сортировкой LowComparator"));

        listOfTimes.add("Сортировка коллекций Person средствами JDK");

        timeSort1.setStartTime();
        personLinkedList1.sort(new BigComparator<>());
        listOfTimes.add(timeSort1.toString("Сортировка коллекции LinkedList"));

        timeSort1.setStartTime();
        personArrayList1.sort(new BigComparator<>());
        listOfTimes.add(timeSort1.toString("Сортировка коллекции ArrayList"));

        // Коллекции TreeSet сортируются при вставке с помощью compareTo
        // можно отсориторовать с помощью другого компаратора
        // Коллекции HashSet сортируются при вставке по HashCode,
        // который переопредлен в классе
        timeSort1.setStartTime();
        TreeSet<Person> personTreeSet1 = new TreeSet<>(new LowComparator<>());

        personTreeSet1.addAll(personArrayList);
        listOfTimes.add(timeSort1.toString("Заполнение коллекции TreeSet c " +
                "сортировкой LowComparator"));

        // Сортировка коллекций пузырьком
        listOfTimes.add("Сортировка коллекций Animal методом " +
                "пузырьковой сортировки");

        timeSort1.setStartTime();
        SortMy.sort(animalArrayList, new BigComparator<Animal>());
        listOfTimes.add(timeSort1.toString("Сортировка коллекции LinkedList"));

        timeSort1.setStartTime();
        SortMy.sort(animalLinkedList, new BigComparator<Animal>());
        listOfTimes.add(timeSort1.toString("Сортировка коллекции ArrayList"));

        listOfTimes.add("Сортировка коллекций Person методом " +
                "пузырьковой сортировки");

        timeSort1.setStartTime();
        SortMy.sort(personLinkedList, new BigComparator<Animal>());
        listOfTimes.add(timeSort1.toString("Сортировка коллекции LinkedList"));

        timeSort1.setStartTime();
        SortMy.sort(personArrayList, new BigComparator<Animal>());
        listOfTimes.add(timeSort1.toString("Сортировка коллекции ArrayList"));

        listOfTimes.add("");

        listOfTimes.add(timeSortAll.toString("Сортировка всех коллекции"));

        listOfTimes.add("/____________/");

        // Итерирование коллекций
        listOfTimes.add("Итерирование коллекций Animal");

        MethodRunningTime timeIterAll = new MethodRunningTime();

        MethodRunningTime timeIter1 = new MethodRunningTime();
        iteratorJDK(animalLinkedList);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции LinkedList " +
                "средствами JDK"));

        timeIter1.setStartTime();
        iteratorJDK(animalArrayList);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции ArrayList " +
                "средствами JDK"));

        timeIter1.setStartTime();
        iteratorJDK(animalHashSet);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции HashSet " +
                "средствами JDK"));

        timeIter1.setStartTime();
        iteratorJDK(animalTreeSet);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции TreeSet " +
                "средствами JDK"));

        listOfTimes.add("Итерирование коллекций Person");

        timeIter1.setStartTime();
        iteratorJDK(personLinkedList);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции LinkedList " +
                "средствами JDK"));

        timeIter1.setStartTime();
        iteratorJDK(personArrayList);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции ArrayList " +
                "средствами JDK"));

        timeIter1.setStartTime();
        iteratorJDK(personHashSet);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции HashSet " +
                "средствами JDK"));

        timeIter1.setStartTime();
        iteratorJDK(personTreeSet);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции TreeSet " +
                "средствами JDK"));

        listOfTimes.add("Итерирование коллекций Animal");

        timeIter1.setStartTime();
        myIteratorFor(animalLinkedList);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции LinkedList " +
                "другим способом"));

        timeIter1.setStartTime();
        myIteratorFor(animalArrayList);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции ArrayList " +
                "другим способом"));

        timeIter1.setStartTime();
        myIteratorFor(animalHashSet);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции HashSet " +
                "другим способом"));

        timeIter1.setStartTime();
        myIteratorFor(animalTreeSet);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции TreeSet " +
                "другим способом"));

        listOfTimes.add("Итерирование коллекций Person");

        timeIter1.setStartTime();
        myIteratorFor(personLinkedList);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции LinkedList " +
                "другим способом"));

        timeIter1.setStartTime();
        myIteratorFor(personArrayList);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции ArrayList " +
                "другим способом"));

        timeIter1.setStartTime();
        myIteratorFor(personHashSet);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции HashSet " +
                "другим способом"));

        timeIter1.setStartTime();
        myIteratorFor(personTreeSet);
        listOfTimes.add(timeIter1.toString("Итерирование коллекции TreeSet " +
                "другим способом"));

        listOfTimes.add("");

        listOfTimes.add(timeIterAll.toString("Итерирование всех коллекций " +
                "разными способами"));

        listOfTimes.add("/____________/");


        // Удаление коллекций
        listOfTimes.add("Удаление коллекций Animal");

        MethodRunningTime timeDelAll = new MethodRunningTime();

        MethodRunningTime timeDel1 = new MethodRunningTime();
        deleteIteratorJDK(animalLinkedList);
        listOfTimes.add(timeDel1.toString("Удаление коллекции LinkedList " +
                "средствами JDK"));

        timeDel1.setStartTime();
        deleteIteratorJDK(animalArrayList);
        listOfTimes.add(timeDel1.toString("Удаление коллекции ArrayList " +
                "средствами JDK"));

        timeDel1.setStartTime();
        deleteIteratorJDK(animalHashSet);
        listOfTimes.add(timeDel1.toString("Удаление коллекции HashSet " +
                "средствами JDK"));

        timeDel1.setStartTime();
        deleteIteratorJDK(animalTreeSet);
        listOfTimes.add(timeDel1.toString("Удаление коллекции TreeSet " +
                "средствами JDK"));

        listOfTimes.add("Удаление коллекций Person");

        timeDel1.setStartTime();
        deleteIteratorJDK(personLinkedList);
        listOfTimes.add(timeDel1.toString("Удалениее коллекции LinkedList " +
                "средствами JDK"));

        timeDel1.setStartTime();
        deleteIteratorJDK(personArrayList);
        listOfTimes.add(timeDel1.toString("Удаление коллекции ArrayList " +
                "средствами JDK"));

        timeDel1.setStartTime();
        deleteIteratorJDK(personHashSet);
        listOfTimes.add(timeDel1.toString("Удаление коллекции HashSet " +
                "средствами JDK"));

        timeDel1.setStartTime();
        deleteIteratorJDK(personTreeSet);
        listOfTimes.add(timeDel1.toString("Удаление коллекции TreeSet " +
                "средствами JDK"));

        listOfTimes.add("Удаление коллекций Animal");

        timeDel1.setStartTime();
        myDeleteFor(animalLinkedList1);
        listOfTimes.add(timeDel1.toString("Удаление коллекции LinkedList " +
                "другим способом"));

        timeDel1.setStartTime();
        myDeleteFor(animalArrayList1);
        listOfTimes.add(timeDel1.toString("Удаление коллекции ArrayList " +
                "другим способом"));

        timeDel1.setStartTime();
        myDeleteFor(animalHashSet1);
        listOfTimes.add(timeDel1.toString("Удаление коллекции HashSet " +
                "другим способом"));

        timeDel1.setStartTime();
        myDeleteFor(animalTreeSet1);
        listOfTimes.add(timeDel1.toString("Удаление коллекции TreeSet " +
                "другим способом"));

        listOfTimes.add("Удаление коллекций Person");

        timeDel1.setStartTime();
        myDeleteFor(personLinkedList1);
        listOfTimes.add(timeDel1.toString("Удаление коллекции LinkedList " +
                "другим способом"));

        timeDel1.setStartTime();
        myDeleteFor(personArrayList1);
        listOfTimes.add(timeDel1.toString("Удаление коллекции ArrayList " +
                "другим способом"));

        timeDel1.setStartTime();
        myDeleteFor(personHashSet1);
        listOfTimes.add(timeDel1.toString("Удаление коллекции HashSet " +
                "другим способом"));

        timeDel1.setStartTime();
        myDeleteFor(personTreeSet1);
        listOfTimes.add(timeDel1.toString("Удаление коллекции TreeSet " +
                "другим способом"));

        listOfTimes.add("");

        listOfTimes.add(timeDelAll.toString("Удаление всех коллекций " +
                "разными способами"));

        listOfTimes.add("/____________/");
        listOfTimes.add("");
        listOfTimes.add(timeAll.toString("Все операции"));
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


}


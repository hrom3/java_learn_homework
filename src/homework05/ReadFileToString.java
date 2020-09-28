package homework05;

import homework04.DataContainer;
import homework04.StringsHomeTaskMy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class ReadFileToString {
    public static void main(String[] args) {

        // Task 1
        // Получение строки
        String filePath =
                "d:\\repository\\java_learn\\HomeTasks\\Война и мир_книга.txt";
        String data = readAllBytes(filePath);

        // Получение массива слов из строки
        String[] arrayOfWords = data.split("\\s*(\\s|,|!|\\?|;|:|\\(|" +
                "(\\)\\.*\\s*)|\\.+|\\*|(\\s*\"\\.*\\s*))\\s*");

        // Удаление символов "--" из массива слов
        DataContainer<String> cont = new DataContainer<>(arrayOfWords);
        cont.deleteAllEntriesItems("--");
        List<String> listOfWords = Arrays.asList(cont.getItems());

        System.out.println("Count of words in string = " + listOfWords.size());

        // Task 2
        Map<String, Integer> countOfWords = new HashMap<>();

        for (String s : listOfWords) {
            Integer count = Collections.frequency(listOfWords, s);
            countOfWords.put(s, count);
        }

        Map<String, Integer> sortedMap = sortByCount(countOfWords);

        // Task 3
        System.out.println();
        System.out.println("Task 3");

        printNumberOfValuesOfMap(sortedMap, 10);

        // Task 7
        System.out.println();
        System.out.println("Task 7");

        String data1 = data.toLowerCase();
        String[] wordToSearch = {"война", "и", "мир"};
        EasySearch search = new EasySearch();

        for (String toSearch : wordToSearch) {
            long amount = search.search(data, toSearch);
            System.out.println("Count of word \"" + toSearch + "\" with case control in string = " + amount);
            amount = search.search(data1, toSearch);
            System.out.println("Count of word \"" + toSearch + "\" without case control in string = " + amount);
        }

        // Task 6
        System.out.println();
        System.out.println("Task 6");
        RegExSearch regExSearch = new RegExSearch();
        for (String toSearch : wordToSearch) {
            long amount = regExSearch.search(data, toSearch);
            System.out.println("Count of word \"" + toSearch + "\" with case control in string = " + amount);
            amount = regExSearch.search(data1, toSearch);
            System.out.println("Count of word \"" + toSearch + "\" without case control in string = " + amount);
        }
    }

    /**
     * Метод выода первых number строк Map
     *
     * @param map    Map для вывода
     * @param number Количество ячеек для вывода
     */
    public static void printNumberOfValuesOfMap(Map<String, Integer> map,
                                                int number) {
        Iterator<String> itr = map.keySet().iterator();
        int i = 0;
        StringsHomeTaskMy worldTimes = new StringsHomeTaskMy();
        while (i < number && itr.hasNext()) {
            String key = itr.next();
            Integer value = map.get(key);
            System.out.println("Слово \"" + key + "\" повторяется "
                    + value + worldTimes.toTimes(value));
            i++;
        }
    }

    /**
     * Метод сортировки Map по значению value
     * key   = String
     * value = Integer
     *
     * @param unSortedMap не сортированный Mqp
     * @return новый отсортированный Mqp
     */
    private static Map<String, Integer> sortByCount(Map<String,
            Integer> unSortedMap) {
        List<Entry<String, Integer>> list = new LinkedList<>(unSortedMap.entrySet());
        MapComparator comparator = new MapComparator();
        list.sort(comparator);

        // Сохранение порядка размещения с помощью LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    /**
     * Метод преобразует файл в строку
     *
     * @param filePath Строка с путем к фалу для преобразования
     * @return Возвращаемая строка
     */
    private static String readAllBytes(String filePath) {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}



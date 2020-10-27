package homework05;

import homework04.DataContainer;
import homework04.StringsHomeTaskMy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

/*
 * Работа со строками, коллекциями. Война и мир:
 *  1. Скачать книгу "Война и мир" https://www.dropbox.com/s/8mstiwnx9o9btw4/
 * %D0%B2%D0%BE%D0%B9%D0%BD%D0%B0%20%D0%B8%20%D0%BC%D0%B8%D1%80_
 * %D0%BA%D0%BD%D0%B8%D0%B3%D0%B0.txt?dl=0 на компьютер.
 * Используя статью https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
 * и метод readAllBytesJava7 из статьи считать сохранённый файл и сохранить результат
 * счтитывания в переменную типа типа String.
 *  2. Работа с коллекциями:
 * 	    2.0 Знаки препинания, пробелы и переводы строк - это не слова. Регистр в
 * словах имеет значение.
 * 	    2.1 Найти в строке все уникальные слова и поместить их в коллекцию используя Set.
 * 	    2.2 Найти в строке топ 10 слов и вывести количество этих слов используя Map.
 *  Отсортировать по количеству. Распечатать в консоль. Пример: Война - 200 раз,
 * Мир - 100 раз и так далее. Знаки препинания, пробелы и переводы строк - это не слова.
 * 3. Написать интерфейс ISearchEngine. Это будет интерфейс в котором будут методы:
 * 	    3.1 long search(String text, String word) - Метод возвращает информации о
 * количестве раз которое встречается слово в тексте. Первый параметр текст в котором
 * ищем, второй параметр что ищем в тексте
 * 4. Реализовать интерфейс ISearchEngine:
 * 	    4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из
 * класса String. В данной реализации запрещено использовать регулярные выражения в
 * любом виде, для любых задач.
 * 	    4.2* Написать класс RegExSearch реализующий интерфейс ISearchEngine.
 * Реализовать поиск при помощи класса Matcher.
 * 5. Используя реализации интерфейса ISearchEngine вывести информацию как часто
 * встречаются слова "война", "и" (как союз), "мир" вне зависимости от регистра.
 */

public class ReadFileToString {
    public static void main(String[] args) {

        // Task 1
        // Получение строки
        String filePath = "homework" + File.separator + "src" +
                File.separator + "res" + File.separator +
                "Война и мир_книга.txt";
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
     * Метод выода определеного кол-ва первых строк Map
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
     * Метод сортировки Map по значению value
     * key   = String
     * value = Integer
     *
     * @param unSortedMap не сортированный Mqp
     */
    private static <V, E> void sortByCountVer2(Map<V,
            E> unSortedMap) {
        List<Entry<V, E>> list = new LinkedList<>(unSortedMap.entrySet());
        MapComparatorVer2 comparator = new MapComparatorVer2();
        list.sort(comparator);
        // Сохранение порядка размещения с помощью LinkedList
        Map<V, E> sortedMap = new LinkedHashMap<>();
        for (Entry<V, E> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Метод преобразует файл в строку
     *
     * @param filePath Строка с путем к фалу для преобразования
     * @return Возвращаемая строка
     */
    public static String readAllBytes(String filePath) {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
        return data;
    }
}



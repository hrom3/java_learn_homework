package homework05;

import homework04.DataContainer;
import homework04.StringsHomeTaskMyVer3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

import static homework05.ReadFileToString.printNumberOfValuesOfMap;

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

public class TextData {


    public static String[] getWordsFromString(String str) {

        // Получение массива слов из строки
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] arrayOfWords = str.split("\\s*(\\s|,|!|\\?|;|:|\\(|" +
                "(\\)\\.*\\s*)|\\.+|\\*|(\\s*\"\\.*\\s*))\\s*");

        // Удаление символов "--" из массива слов
        DataContainer<String> cont = new DataContainer<>(arrayOfWords);
        cont.deleteAllEntriesItems("--");
        return cont.getItems();
    }

    // Task 2.1
    public static Set<String> getSetFromArr(String[] strArr) {
        TreeSet<String> setOfWords = null;
        if (strArr == null || strArr.length == 0) {
            return setOfWords;
        }
        List<String> collection = Arrays.asList(strArr);
        setOfWords = new TreeSet<>(collection);

        System.out.println();
        System.out.println("Task 3");
        System.out.println("Count of words in string = " + setOfWords.size());

        return setOfWords;
    }

    // Task 2.2
    public static void printMapFromArr(String[] strArr, int numberOfTopWordsToPrint) {
        Map<String, Integer> countOfWords = new HashMap<>();
        if (strArr == null || strArr.length == 0) {
            System.out.println("Bad array");
        }
        List<String> collection = Arrays.asList(strArr);

        for (String s : collection) {
            Integer count = Collections.frequency(collection, s);
            countOfWords.put(s, count);
        }

        sortByCountVer2(countOfWords);

        System.out.println();
        System.out.println("Task 3");

        printNumberOfValuesOfMap(countOfWords, numberOfTopWordsToPrint);
    }


    // Task 5.2
    public static void printFoundByRegExSearchWordsAndCount(String str,
                                                            String[] wordsToSearch){
        System.out.println();
        System.out.println("Task 5.2");
        if (str == null || str.length() == 0) {
            System.out.println("bad string");
            return;
        }
        if (wordsToSearch == null || wordsToSearch.length == 0) {
            System.out.println("bad string array");
            return;
        }

        String data = str.toLowerCase();
        RegExSearch search = new RegExSearch();
        long amount = 0;

        for (String toSearch : wordsToSearch) {
            String word = toSearch.toLowerCase();
            amount = search.search(str, toSearch);

            System.out.println("Count of word \"" + toSearch +
                    "\" with case control in string = " + amount);

            amount = search.search(data, word);

            System.out.println("Count of word \"" + word +
                    "\" without case control in string = " + amount);
        }
    }

    // Task 5.1
    public static void printFoundByEasySearchWordsAndCount(String str,
                                                           String[] wordsToSearch){
        System.out.println();
        System.out.println("Task 5.1");

        if (str == null || str.length() == 0) {
            System.out.println("bad string");
            return;
        }
        if (wordsToSearch == null || wordsToSearch.length == 0) {
            System.out.println("bad string array");
            return;
        }

        String data = str.toLowerCase();
        EasySearch search = new EasySearch();
        long amount = 0;

        for (String toSearch : wordsToSearch) {
            String word = toSearch.toLowerCase();
            amount = search.search(str, toSearch);

            System.out.println("Count of word \"" + toSearch +
                    "\" with case control in string = " + amount);

            amount = search.search(data, word);

            System.out.println("Count of word \"" + word +
                    "\" without case control in string = " + amount);
        }
    }


    /**
     * Метод выода определеного кол-ва первых строк Map
     *
     * @param map    Map для вывода
     * @param number Количество ячеек для вывода
     */
    private static <V extends String, E extends Number> void printNumberOfValuesOfMap(Map<V, E> map, int number) {
        final String[] times = {"раз", "раза", "раз"};
        Iterator<V> itr = map.keySet().iterator();
        int i = 0;
        StringsHomeTaskMyVer3 worldTimes = new StringsHomeTaskMyVer3();
        while (i < number && itr.hasNext()) {
            String key = itr.next();
            Integer value = (Integer) map.get(key);
            System.out.println("Слово \"" + key + "\" повторяется "
                    + value + worldTimes.wordForNumber(value, times));
            i++;
        }
    }

    /**
     * Метод сортировки Map по значению value
     * key   = String
     * value = Integer
     *
     * @param unSortedMap не сортированный Map
     * @return новый отсортированный Map
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
     *
     * @param unSortedMap не сортированный Map
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



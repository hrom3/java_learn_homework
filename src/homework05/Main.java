package homework05;

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

import java.io.File;
import java.util.Set;

import static homework05.ReadFileToString.readAllBytes;
import static homework05.TextData.*;

public class Main {
    public static void main(String[] args) {

        String filePath = "homework" + File.separator + "src" +
                File.separator + "res" + File.separator +
                "Война и мир_книга.txt";
        String data;
        String[] arrWords;
        Set<String> setWords = null;
        String[] wordToSearch = {"война", "и", "мир"};
        int numberOfTopWords = 10;

        // Task 1
        // Получение строки
        data = readAllBytes(filePath);

        // Получение массива строк
        arrWords = getWordsFromString(data);
        System.out.println(arrWords.length);

        // Task 2.1
        // Создание Set
        setWords = getSetFromArr(arrWords);

        // Task 2.2
        printMapFromArr(arrWords, numberOfTopWords);

        // Task 5.1
        printFoundByEasySearchWordsAndCount(data, wordToSearch);

        // Task 5.2
        printFoundByRegExSearchWordsAndCount(data, wordToSearch);
    }
}

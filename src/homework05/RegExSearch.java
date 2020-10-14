package homework05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Task 6 4.2* Написать класс RegExSearch реализующий интерфейс ISearchEngine.
 * Реализовать поиск при помощи класса Matcher.
 */
public class RegExSearch implements ISearchEngine {

    @Override
    public long search(String text, String word) {
        Pattern pattern = Pattern.compile("\\b" + word +"\\b");
        Matcher matcher = pattern.matcher(text);
        long count = 0L;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}

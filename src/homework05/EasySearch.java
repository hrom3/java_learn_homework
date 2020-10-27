package homework05;

/* Task 4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из
 * класса String. В данной реализации запрещено использовать регулярные выражения в
 * любом виде, для любых задач.
 */

public class EasySearch implements ISearchEngine {
    public long search(String text, String word) {
        long amount = 0;
        int wordLength = word.length();
        int index;
        int startIndex = 0;
        int beginIndex;
        int nextIndex;
        boolean isBegin; //= false;
        boolean isEnd; //= false;

        do {
            isBegin = false;
            isEnd = false;
            index = text.indexOf(word, startIndex);
            if (index < 0) {
                return amount;
            }
            if (index == 0) {
                beginIndex = index;
                isBegin = true;
            } else {
                beginIndex = index - 1;
            }
            if ((index + wordLength) >= text.length()) {
                nextIndex = index + wordLength;
                isEnd = true;
            } else {
                nextIndex = index + wordLength;
            }
            if (isBegin && isEnd) {
                amount++;
                return amount;
            }
            String subStr = text.substring(beginIndex, nextIndex + 1);
            if (!isBegin) {
                isBegin = isIndexBeginWord(subStr, 0);
            }
            if (!isEnd) {
                isEnd = isIndexEndWord(subStr, subStr.length() - 1);
            }

            if (isBegin && isEnd) {
                amount++;
            }
            startIndex = nextIndex;
        } while (1 == 1);
    }

    private static boolean isIndexBeginWord(String str, int index) {
        // только однословные союзы
        String[] beforeFirstLetter = {" ", "\"", "("};
        // однословные союзы и сокращения
//        String[] beforeFirstLetter = {".", " ", "\"", "("};

        for (String s : beforeFirstLetter) {
            if (str.startsWith(s, index)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIndexEndWord(String str, int index) {
        String[] beforeFirstLetter = {" ", "\"", "\n", ")", ".", ",",
                "?", "!", ";", ":"};
        for (String s : beforeFirstLetter) {
            if (str.startsWith(s, index)) {
                return true;
            }
        }
        return false;
    }
}

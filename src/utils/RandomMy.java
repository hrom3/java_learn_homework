package utils;

import homework05.ReadFileToString;

import java.io.File;
import java.util.Random;


public class RandomMy {
    final static private char[] allString = ("QWERTYUIOPASDFGHJKLZXCVBNM" +
            "qazwsxedcrfvtgbyhnujmiklop" +
            "ЯФЙЧЫЦСВУМАКИПЕТРНЬОГБЛШЮДЩЖЗХЭЪЁё" +
            "яфйчыцсвумакипетрньогблшюдщжзхъэ").toCharArray();

    final static private char[] allRusString = ("ЯФЙЧЫЦСВУМАКИПЕТРНЬОГБЛШЮДЩЖЗХЭЪ" +
            "яфйчыцсвумакипетрньогблшюдщжзхъэ").toCharArray();

    final static private Random rnd = new Random();

    public static String randomNextString(int length) {
        StringBuilder b = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            b.append(allString[rnd.nextInt(allString.length)]);
        }
        return  b.toString();
    }

    public static String randomNextStringRus(int length) {
        StringBuilder b = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            b.append(allRusString[rnd.nextInt(allRusString.length)]);
        }
        return  b.toString();
    }


    public static String randomNextNick() {
        String filePath =
                "d:\\repository\\java_learn\\HomeTasks\\pet_niks.txt";
        String data = ReadFileToString.readAllBytes(filePath);

        // Получение массива слов из строки
        String[] arrayOfWords = data.split("\\s*(\\s|,|!|\\?|;|:|\\(|" +
                "(\\)\\.*\\s*)|\\.+|\\*|(\\s*\"\\.*\\s*))\\s*");

        int lengthOfArray = arrayOfWords.length;
        String b = arrayOfWords[rnd.nextInt(lengthOfArray)];
        return  b;
    }

    public static String randomNextName() {
        String filePath = "homework" + File.separator + "src" +
                File.separator + "res" + File.separator +
                "names.txt";
        String data = ReadFileToString.readAllBytes(filePath);

        // Получение массива слов из строки
        String[] arrayOfWords = data.split("\\s*(\\s|,|!|\\?|;|:|\\(|" +
                "(\\)\\.*\\s*)|\\.+|\\*|(\\s*\"\\.*\\s*))\\s*");

        int lengthOfArray = arrayOfWords.length;
        String b = arrayOfWords[rnd.nextInt(lengthOfArray)];
        return  b;
    }
}

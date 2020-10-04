package utils;

import java.util.Random;

public class RandomMy {
    final static private char[] allString = ("QWERTYUIOPASDFGHJKLZXCVBNM" +
            "qazwsxedcrfvtgbyhnujmiklop" +
            "ЯФЙЧЫЦСВУМАКИПЕТРНЬОГБЛШЮДЩЖЗХЭЪЁё" +
            "яфйчыцсвумакипетрньогблшюдщжзхъэ").toCharArray();

    final static private Random rnd = new Random();
    public static String randomNextString(int length) {
        StringBuilder b = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            b.append(allString[rnd.nextInt(allString.length)]);
        }
        return  b.toString();
    }
}

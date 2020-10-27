package homework04;

/*
 * Строки. Все методы пишутся в одном классе:
 * 1. Написать метод String toString(int number).
 * 	1.1 В данном методе произвести конвертацию переданного числа в число прописью.
 * Числа от - 999 999 999 до 999 999 999
 * 	1.2 Пример передали: 223. Получили "Двести двадцать три"
 * 2. Написать метод String toString(double number).
 * 	2.1 В данном методе произвести конвертацию переданного числа в число прописью.
 *  Выводить до сотых, без округления.
 * 	2.2 Пример передали: 223.1599999. Получили "Двести двадцать три целых
 * пятнадцать сотых".
 * 3. Написать метод String toWeek(int day).
 * 	3.1 В данном методе посчитать количество прошедших недель по
 * переданному числу дней.
 * 	3.2 Пример передали: 5. Получили "0 недель"
 * 	3.3 Пример передали: 14. Получили "2 недели"
 * 	3.4 Пример передали: 177. Получили "25 недель"
 * 4.* Написать метод String toHoursMinuteSecondMillisecond(long millisecond,
 * boolean shortFormat).
 * 	4.1 В данном методе конвертируют переданные миллисекунды в количество
 * часов, минут, секунд и миллисекунд.
 * 	4.2 В зависимости от параметра shortFormat возвращать либо короткое
 * написание в формате HH:mm:ss.SSS, где HH - это часы, mm - это минуты,
 * ss - это секунды, SSS - это миллисекунды. Либо полное написание
 * 	4.3 Пример передали: 7789001, true. Получили 02:09:49.001 - прошу обратить
 * что в цифрах могут быть ведущие нули: "02", "09"
 * 	4.4 Пример передали: 7789001, false. Получили 2 часа 9 минут 49
 * секунд 1 миллисекунда
 */

import homework02.CountNumeralsInNumber;

public class StringsHomeTaskMyVer2 {
    final private String[] thousands = {"тысяча", "тысячи", "тысяч"};
    final private String[] millions = {"миллион", "миллиона", "миллионов"};
    final private String[] integerPrats = {"целая", "целые", "целых"};
    final private String[] hundredth = {"сотая", "сотые", "сотых"};
    final private String[] tenths = {"десятая", "десятые", "десятых"};
    final private String[] weeks = {"неделя", "недели", "недель"};
    final private String[] times = {"раз", "раза", "раз"};
    final private String[] hours = {"час", "часа", "часов"};
    final private String[] minutes = {"минута", "минуты", "минут"};
    final private String[] seconds = {"секунда", "секунды", "секунд"};

    /**
     * Метод преобразования целого числа в строку
     * максимальное число по модулю 999 999 999
     *
     * @param number целое число для конвертации
     * @return возвращаемая строка
     */
    public String toString(int number) {
        return toStringDifferentGender(number, false);
    }

    /**
     * Метод преобразования целого числа в строку
     * максимальное число по модулю 999 999 999
     * возвращает число женского или мужского рода
     * в зависимости от переменной isFemale
     *
     * @param number   целое число для конвертации
     * @param isFemale true - женский, false - мужской
     * @return возвращаемая строка
     */
    private String toStringDifferentGender(int number, boolean isFemale) {
        String sign = "";
        String str = null;

        if (number < 0) {
            sign = "минус ";
            number = -number;
        }
        if (number == 0) {
            return "Ноль ";
        }

        str = sign + millionToBillion(number, isFemale);
        return makeFirstLetterUpperCaseVer2(str);

    }

    /**
     * Метод преобразования числа типа double в строку c точностью до сотых
     * максимальное число по модулю 999 999 999, 99
     *
     * @param number число для конвертации
     * @return возвращаемая строка
     */
    public String toString(double number) {
        if (number < -999_999_999.99 || number > 999_999_999.99) {
            return "Bad data";
        }
        int fractionalPart;
        int numberInt;
        String fractionalPartStr;
        String numberIntStr;

        if (number < 0) {
            number = -number;
        }

        numberInt = (int) number;
        fractionalPart = (int) ((number - numberInt) * 100);
        numberIntStr = toStringDifferentGender(numberInt, true);
        if (fractionalPart % 10 == 0) {
            int tmp = fractionalPart / 10;
            fractionalPartStr = nullToNine(tmp, true) +
                    additionalWords(tmp, tenths);
        } else {
            fractionalPartStr = nullToNinetyNine(fractionalPart, true) +
                    additionalWords(fractionalPart, hundredth);
        }
        return numberIntStr + additionalWords(numberInt, integerPrats)
                + " " + fractionalPartStr;
    }

    /**
     * Метод преобразования числа дней в в полное число недель
     *
     * @param number кол-во дней
     * @return количество недель
     */
    public String toWeek(int number) {
        if (number < 0) {
            return "Bad date";
        }
        int weekCount = number / 7;

        return weekCount + " " + additionalWords(weekCount, weeks);
    }

    /**
     * Метод преобразования числа в кол-во раз
     *
     * @param number число
     * @return строка кол-во раз
     */
    public String toTimes(int number) {
        if (number < 0) {
            return "Bad date";
        }
        return additionalWords(number, times);
    }

    /**
     * Метод преобразования милисекунд в строку  в виде
     *  в формате HH:mm:ss.SSS (shortFormat == true) или в формате
     *  XX часов XX минут XX секунд XXX миллисекунд (shortFormat == false)
     *  незначащие ноли не отображать
     *
     * @param millisecond значение в миллисекундах
     * @param shortFormat выбор сокращенный полный формат
     * @return возвращаемая строка
     */
    public String toHoursMinuteSecondMillisecond(long millisecond,
                                                 boolean shortFormat) {
        if (millisecond < 0) {
            return "Bad data";
        }
        long hour = millisecond / 3_600_000;
        int min = (int) (millisecond % 3_600_000 / 60_000);
        int sec = (int) (millisecond % 3_600_000 % 60_000 / 1_000);
        int msec = (int) (millisecond % 3_600_000 % 60_000 % 1000);
        int lastNumber = (int) (hour % 100);

        if (shortFormat) {
            return String.format("%02d:%02d:%02d.%03d", hour, min,
                    sec, msec);
        } else {
            return hour + " " + additionalWords(lastNumber, hours) +
                    " " + min + " " + additionalWords(min, minutes) +
                    " " + sec + " " + additionalWords(sec, seconds) +
                    " " + msec + " милли" + additionalWords(msec, seconds);
        }
    }

    /**
     * Преобразование числа от 0 до 9 в строку
     * выбор рода цифры осуществляется с помощью isFemaleGender
     *
     * @param number цифра для преобразования
     * @param isFemaleGender мужской/женский род
     * @return возвращаемая строка
     */
    private String nullToNine(int number, boolean isFemaleGender) {
        switch (number) {
            case 0:
                return "ноль ";
            case 1:
                if (!isFemaleGender) {
                    return "один ";
                } else {
                    return "одна ";
                }
            case 2:
                if (!isFemaleGender) {
                    return "два ";
                } else {
                    return "две ";
                }
            case 3:
                return "три ";
            case 4:
                return "четыре ";
            case 5:
                return "пять ";
            case 6:
                return "шесть ";
            case 7:
                return "семь ";
            case 8:
                return "восемь ";
            case 9:
                return "девять ";
            default:
                return "bad";
        }
    }

    /**
     * Преобразование числа от 10 до 19 в строку
     *
     * @param number число для преобразования
     * @return возвращаемая строка
     */
    private String tenToNineteen(int number) {
        switch (number) {
            case 10:
                return "десять ";
            case 11:
                return "одиннадцать ";
            case 12:
                return "двенадцать ";
            case 13:
                return "тринадцать ";
            case 14:
                return "четырнадцать ";
            case 15:
                return "пятнадцать ";
            case 16:
                return "шестнадцать ";
            case 17:
                return "семнадцать ";
            case 18:
                return "восемнадцать ";
            case 19:
                return "девятнадцать ";
            default:
                return "bad";
        }
    }

    /**
     * Преобразование числа от 20 до 99 в строку
     * выбор рода последней цифры осуществляется с помощью isFemaleGender
     *
     * @param number число для преобразования
     * @param isFemaleGender мужской/женский род
     * @return возвращаемая строка
     */
    private String twentyToNinetyNine(int number, boolean isFemaleGender) {
        int number1 = number / 10;
        int number2 = number % 10;

        String nullToNine = number2 != 0 ? nullToNine(number2, isFemaleGender) : "";

        switch (number1) {
            case 2:
                return "двадцать " + nullToNine;
            case 3:
                return "тридцать " + nullToNine;
            case 4:
                return "сорок " + nullToNine;
            case 5:
                return "пятьдесят " + nullToNine;
            case 6:
                return "шестьдесят " + nullToNine;
            case 7:
                return "семьдесят " + nullToNine;
            case 8:
                return "восемьдесят " + nullToNine;
            case 9:
                return "девяносто " + nullToNine;
            default:
                return "bad";
        }
    }

    /**
     * Преобразование числа от 0 до 99 в строку
     * выбор рода последней цифры осуществляется с помощью isFemaleGender
     *
     * @param number число для преобразования
     * @param isFemaleGender мужской/женский род
     * @return возвращаемая строка
     */
    private String nullToNinetyNine(int number, boolean isFemaleGender) {
        if (number < 10) {
            return nullToNine(number, isFemaleGender);
        } else if (number < 20) {
            return tenToNineteen(number);
        } else {
            return twentyToNinetyNine(number, isFemaleGender);
        }
    }

    /**
     * Преобразование числа от 0 до 999 в строку
     * выбор рода последней цифры осуществляется с помощью isFemaleGender
     *
     * @param number число для преобразования
     * @param isFemaleGender мужской/женский род
     * @return возвращаемая строка
     */
    private String nullToNineHundredNinetyNine(int number,
                                               boolean isFemaleGender) {
        int number1 = number / 100;
        int number2 = number % 100;

        String nullToNinetyNine = number2 != 0 ? nullToNinetyNine(number2,
                isFemaleGender) : "";

        switch (number1) {
            case 0:
                return nullToNinetyNine;
            case 1:
                return "сто " + nullToNinetyNine;
            case 2:
                return "двесте " + nullToNinetyNine;
            case 3:
                return "триста " + nullToNinetyNine;
            case 4:
                return "четырста " + nullToNinetyNine;
            case 5:
                return "пятьсот " + nullToNinetyNine;
            case 6:
                return "шестьсот " + nullToNinetyNine;
            case 7:
                return "семьсот " + nullToNinetyNine;
            case 8:
                return "восемьсот " + nullToNinetyNine;
            case 9:
                return "девятьсот " + nullToNinetyNine;
            default:
                return "bad";
        }
    }

    /**
     * Выбор слова для дабавления после числа
     *
     * @param number число
     * @param words массив из 3 слов (с разными окончаниями)
     * @return возвращаемая строка
     */
    private String additionalWords(int number, String[] words) {
        number = number > 20 ? number % 10 : number;

        switch (number) {
            case 1:
                return words[0];
            case 2:
            case 3:
            case 4:
                return words[1];
            default:
                return words[2];
        }
    }

    /**
     * Преобразование числа от 0 до 999 999 в строку
     * выбор рода последней цифры осуществляется с помощью isFemale
     *
     * @param number число для преобразования
     * @param isFemale мужской/женский род
     * @return возвращаемая строка
     */
    private String thousandToMillion(int number, boolean isFemale) {
        int number1 = number / 1_000;
        int number2 = number % 1_000;
        String nullToNineHandNinetyNine;
        if (number2 == 0) {
            nullToNineHandNinetyNine = "";
        } else {
            nullToNineHandNinetyNine = nullToNineHundredNinetyNine(number2,
                    isFemale);
        }
        if (number1 == 0) {
            return nullToNineHandNinetyNine;
        }
        return nullToNineHundredNinetyNine(number1, true)
                + additionalWords(number1, thousands) + " "
                + nullToNineHandNinetyNine;
    }

    /**
     * Преобразование числа от 0 до 999 999 999 в строку
     * выбор рода последней цифры осуществляется с помощью isFemale
     *
     * @param number число для преобразования
     * @param isFemale мужской/женский род
     * @return возвращаемая строка
     */
    private String millionToBillion(int number, boolean isFemale) {
        int number1 = number / 1_000_000;
        int number2 = number % 1_000_000;

        String nullToMillion = number2 != 0 ? thousandToMillion
                (number2, isFemale) : "";
        if (number1 == 0) {
            return nullToMillion;
        }
        return nullToNineHundredNinetyNine(number1, false)
                + additionalWords(number1, millions) + " "
                + nullToMillion;
    }

    /**
     * Метод изменяет первую букву в строке на большую через char
     * (обязательное условие первая буква маленькая иначе может быть беда)
     *
     * @param string строка для измения первой буквы
     * @return возврвщаемая строка
     */
    private String makeFirstLetterUpperCase(String string) {
        StringBuilder strBuild = new StringBuilder(string);
        char ch = (char) (strBuild.charAt(0) - 32);
        strBuild.setCharAt(0, ch);
        return strBuild.toString();
    }

    /**
     * Метод изменяет первую букву в строке на большую через UpperCase
     *
     * @param string строка для измения первой буквы
     * @return возврвщаемая строка
     */
    private String makeFirstLetterUpperCaseVer2(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
package homework08.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;

public class DateFromArgs {

    private final static SimpleDateFormat STRING_FROM_DATE_NBRB = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat STRING_FROM_DATE_BELAGRO = new SimpleDateFormat("MM/dd/yyyy");
    private final static SimpleDateFormat DATE_FROM_STRING = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Возвращает TreeSet со значениями тип Date
     *
     * @param args Массив строк для обработки
     * @return TreeSet со значениями тип Date в
     */
    protected static TreeSet<Date> dateArrListFromDate(String[] args) {
        TreeSet<Date> listOfDate = new TreeSet<>();

        if (args.length > 1) {
            System.out.println("The program is launched with more than 1 argument. " +
                    "Only the first argument will be used");
        }

        String delimiterDash = "-";
        String delimiterComma = ",";
        String strWithDate = args[0];
        boolean isDelimiterDash;
        boolean isDelimiterComma;
        int indexOfDelimiter;
        isDelimiterDash = strWithDate.contains(delimiterDash);

        isDelimiterComma = strWithDate.contains(delimiterComma);

        if (!isDelimiterComma && !isDelimiterDash) {
            try {
                listOfDate.add(strToDate(strWithDate));
                return listOfDate;
            } catch (ParseException e) {
               throw new BadArgumentException(e.getMessage());
            }
        }
            // Заполняем list значениями типа 20.01.2016-20.02.2016
        if (!isDelimiterComma && isDelimiterDash) {
            indexOfDelimiter = strWithDate.indexOf(delimiterDash);
            String dateStart = strWithDate.substring(0, indexOfDelimiter);
            String dateEnd = strWithDate.substring(indexOfDelimiter + 1);
            try {
                Date date2 = strToDate(dateEnd);
                Date date1 = strToDate(dateStart);

                if (date1.equals(date2)) {
                    listOfDate.add(date1);
                    return listOfDate;
                }
                if (date1.compareTo(date2) < 0) {
                    Calendar start = Calendar.getInstance();
                    Calendar end = Calendar.getInstance();
                    start.setTime(date1);
                    end.setTime(date2);
                    listOfDate.add(date1);
                    while (!start.equals(end)) {
                        start.add(Calendar.DATE, 1);
                        listOfDate.add(start.getTime());
                    }
                    return listOfDate;
                }
                throw new BadArgumentException();
            } catch (ParseException e) {
                throw new BadArgumentException(e.getMessage());
            }
        }
            // Заполняем list значениями типа 20.01.2016,22.01.2016
        if (isDelimiterComma && !isDelimiterDash) {
            int indexStart = 0;
            while (strWithDate.contains(delimiterComma)) {
                String substr = strWithDate.substring(indexStart,
                        strWithDate.indexOf(delimiterComma));
                try {
                    listOfDate.add(strToDate(substr));
                    strWithDate = strWithDate.substring(strWithDate.indexOf(delimiterComma) + 1);
                     if (!strWithDate.contains(delimiterComma)) {
                        listOfDate.add(strToDate(strWithDate));
                     }
                } catch (ParseException e) {
                    throw new BadArgumentException(e.getMessage());
                }
            }
            return listOfDate;
        }
        throw new BadArgumentException();
    }

    private static Date strToDate(String str) throws ParseException {
        return DATE_FROM_STRING.parse(str);
    }

    public static String dateToStrNBRB(Date date) {
        return STRING_FROM_DATE_NBRB.format(date);
    }

    public static String dateToStrBelAgro(Date date) {
        return STRING_FROM_DATE_BELAGRO.format(date);
    }
//    public static void main(String[] args) {
//        TreeSet<Date> dateTreeSet = dateArrListFromDate(args);
//        for (Date date : dateTreeSet) {
//            System.out.println(dateToStr(date));
//        }
//    }
}

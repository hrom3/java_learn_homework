package homework04;

public class StringsMyTest {
    public static void main(String[] args) {
        int number = -1;
        StringsHomeTaskMyVer2 toString = new StringsHomeTaskMyVer2();
        for (int i = 1; i < 999_999_999; i *= 2) {

            System.out.println(toString.toString(i));
        }
        System.out.println(toString.toString(number));
        System.out.println(toString.toString(0));
        System.out.println(toString.toString(-21_999_999));
        System.out.println(toString.toString(50_050_999));
        System.out.println(toString.toString(-22_200_999));
        System.out.println(toString.toString(-923_991_999));
        System.out.println(toString.toString(-24_992_999));
        System.out.println(toString.toString(-24_990_999));
        System.out.println(toString.toString(-25_995_999));
        System.out.println();
        System.out.println(toString.toString((double) number));
        System.out.println(toString.toString(0.0));
        System.out.println(toString.toString(223.309999));
        System.out.println(toString.toString(-21_999_991.1));
        System.out.println(toString.toString(50_050_992.12424245));
        System.out.println(toString.toString(-22_200_993.1451));
        System.out.println(toString.toString(-923_991_9990.27722));
        System.out.println(toString.toString(-24_992_994.0000000));
        System.out.println(toString.toString(-24_990_995.45245));
        System.out.println(toString.toString(-25_995_990.010));
        System.out.println(toString.toString(0.15));

        System.out.println();
        System.out.println(toString.toWeek(number));
        System.out.println(toString.toWeek(5));
        System.out.println(toString.toWeek(14));
        System.out.println(toString.toWeek(177));

        System.out.println();
        System.out.println(toString.toHoursMinuteSecondMillisecond
                (7789001, false));
        System.out.println(toString.toHoursMinuteSecondMillisecond
                (7789001, true));
        System.out.println(toString.toHoursMinuteSecondMillisecond
                (Long.MAX_VALUE, false));
        System.out.println(toString.toHoursMinuteSecondMillisecond
                (Long.MAX_VALUE, true));

    }
}

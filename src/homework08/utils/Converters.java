package homework08.utils;

public class Converters {

    public static int getIntFromString(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -9999;
        }
    }

    public static double getDoubleFromString(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return -9999.;
        }
    }
}

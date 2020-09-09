package homework02;

public class CountNumeralsInNumber {
    public static int lengthOfNumber(long number) {
        int length;
        long modNumber = Math.abs(number);
        if (modNumber != 0) {
            length = (int) Math.log10(modNumber) + 1;
        } else {
            length = 1;
        }
        return length;
    }
}

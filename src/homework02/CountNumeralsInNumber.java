package homework02;

public class CountNumeralsInNumber {
    /**
     * Поличение кол-ва цифр из которых состоит число
     *
     * @param number передоваемое число
     * @return длинна переданного числа
     */

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

    public static int lengthOfNumber(int number) {
        return lengthOfNumber((long) number);
    }
}

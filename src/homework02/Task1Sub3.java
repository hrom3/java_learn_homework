package homework02;

import java.util.Scanner;

public class Task1Sub3 {
    public static void main(String[] args) {
        double number;
        double result = 1;
        int degreeOfNumber = 0;

        number = setNumber();
        if (number != 0) {
            degreeOfNumber = setPowNumber();
            if (degreeOfNumber > 0) {
                for (int i = 0; i < degreeOfNumber; i++) {
                    result *= number;
                }
            } else if (degreeOfNumber < 0) {
                degreeOfNumber = -degreeOfNumber;
                for (int i = 0; i < degreeOfNumber; i++) {
                    result *= number;
                }
                result = 1 / result;
            }
            System.out.println("The number " + number + " to the power of " + degreeOfNumber + " is " + result);
        } else {
            System.out.println("The number " + number + " is always 0");
        }
    }

    /**
     * Метод получения числа из консоли
     *
     * @return возвращаемое значение
     */
    static double setNumber() {
        double countOfNumber = 0;
        boolean isBadNumber = true;
        do {
            double userNumber = 0;
            boolean isException = false;
            System.out.println("Type number for exponentiation and press ENTER");
            try {
                Scanner scan = new Scanner(System.in);
                String userNumberString = scan.next();
                userNumber = Double.parseDouble(userNumberString);
            } catch (NumberFormatException e) {
                System.out.println("Bad format" + e);
                isException = true;
            }
            if (Double.isInfinite(userNumber) || Double.isNaN(userNumber)) {
                isException = true;
                System.out.println("Bad format: Infinite or NaN");
            }
            if (isException) {
                continue;
            }
            countOfNumber = userNumber;
            isBadNumber = false;
        } while (isBadNumber);
        return countOfNumber;
    }

    /**
     * Метод получения из консоли значения степени
     * (целое число)
     *
     * @return значение степени
     */
    static int setPowNumber() {
        int degree = 0;
        int userNumber;
        boolean isBadDegree = true;
        do {
            System.out.println("Type integer degree of number and press ENTER");
            try {
                Scanner scan = new Scanner(System.in);
                String userNumberString = scan.next();
                userNumber = Integer.parseInt(userNumberString);
            } catch (NumberFormatException e) {
                System.out.println("Bad format " + e);
                continue;
            }
            degree = userNumber;
            isBadDegree = false;
        } while (isBadDegree);
        return degree;
    }

}

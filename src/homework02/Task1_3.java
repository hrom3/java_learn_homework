package homework02;

import java.util.Scanner;

public class Task1_3 {
    public static void main(String[] args) {
        double number;
        double result = 1;
        int degreeOfNumber;

        number = setNumber();
        if (number != 0) {
            degreeOfNumber = setPowNumber();
            if (degreeOfNumber != 0) {
                for (int i = 0; i < degreeOfNumber; i++) {
                    result *= number;
                }
            }
            System.out.println("The number " + number + " to the power of " + degreeOfNumber + " is " + result);
        } else {
            System.out.println("The number " + number + " cannot be raised to a power");
        }
    }

    // input Number
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

    // input Power
    static int setPowNumber() {
        int degree = 0;
        boolean isBadDegree = true;
        do {
            int userNumber = 0;
            boolean isException = false;
            System.out.println("Type integer degree of number and press ENTER");
            try {
                Scanner scan = new Scanner(System.in);
                String userNumberString = scan.next();
                userNumber = Integer.parseInt(userNumberString);
            } catch (NumberFormatException e) {
                System.out.println("Bad format " + e);
                continue;
            }
            if (userNumber >= 0) {
                degree = userNumber;
                isBadDegree = false;
            } else {
                System.out.println("The degree of number must be more than or equal to 0");
            }
        } while (isBadDegree);
        return (degree);
    }

}

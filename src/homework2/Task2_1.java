package homework2;

import java.util.Scanner;

public class Task2_1 {
    public static void main(String[] agrs) {
        int arrLength;
        int[] array;

        arrLength = getArrayLength();
        array = getNumbersOfArray(arrLength);

        // Task 2.1.1
        System.out.println("Task 2.1.1");
        if (array.length > 0) {
            int i = 0;
            do {
                System.out.print(array[i] + " ");
                i++;
            } while (i < array.length);
            System.out.println('\n');
        }

        // Task 2.1.2
        System.out.println("Task 2.1.2");
        int i = 0;
        while (i < array.length) {
            System.out.print(array[i] + " ");
            i++;
        }
        System.out.println('\n');

        // Task 2.1.3
        System.out.println("Task 2.1.3");
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println('\n');

        // Task 2.1.4
        System.out.println("Task 2.1.4");
        for (int elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println('\n');
    }

    /**
     * Метод запрашивает у пользователя число для получения длинны массива
     * ОГРАНИЧЕНИЯ: только целые числа, минимальное число 1, максимальное
     * задано в переменной maxArrayLength
     *
     * @return целое число
     */
    static int getArrayLength() {
        int arrayLength = 0;
        int maxArrayLength = 20;

        do {
            int userNumber;
            System.out.println("Type array length as integer number and press ENTER:");
            try {
                Scanner scanNumber = new Scanner(System.in);
                userNumber = scanNumber.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Bad format" + e + '\n');
                continue;
            }
            if (userNumber < 1 || userNumber > maxArrayLength) {
                System.out.println("Number must be more than 0 and less than or equal to" + maxArrayLength + '\n');
                continue;
            }
            arrayLength = userNumber;
        } while (arrayLength == 0);
        return arrayLength;
    }

    /**
     * Метод зоплняет масиив определенной длинны заначениями запрошенными у
     * пользователя, после ввода каждого числа необходимо нажать "Enter"
     * ОГРАНИЧЕНИЯ: только целые числа
     *
     * @param countOfArray длина массива не может быть меньше 0
     * @return массив целочисленныз начений
     */
    static int[] getNumbersOfArray(int countOfArray) {   // ввод чисел пользователем
        int[] arrOfNumbers;
        if (countOfArray > 0) {
            arrOfNumbers = new int[countOfArray];
            int userNumber;
            System.out.println("Type " + countOfArray + " numbers and press ENTER after each numeral");
            for (int i = 0; i < countOfArray; i++) {
                try {
                    Scanner scan = new Scanner(System.in);
                    String userNumberString = scan.next();
                    userNumber = Integer.parseInt(userNumberString);
                } catch (NumberFormatException e) {
                    System.out.println("Bad format " + e);
                    System.out.println("\nType valid numbers and press ENTER after each numeral");
                    i--;
                    continue;
                }
                arrOfNumbers[i] = userNumber;
            }
        } else {
            System.out.println("error 1");
            arrOfNumbers = new int[0];
        }
        return arrOfNumbers;
    }
}



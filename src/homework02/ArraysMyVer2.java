package homework02;

import java.util.Scanner;

public class ArraysMyVer2 {

    /**
     * Метод запрашивает у пользователя число для получения длинны массива
     * ОГРАНИЧЕНИЯ: только целые числа, минимальное число 1, максимальное
     * задано в переменной maxArrayLength
     *
     * @return целое число
     */
    public static int getArrayLength() {
        int arrayLength = 0;
        int maxArrayLength = 20;

        do {
            int userNumber;
            System.out.println("Type array length as integer number and press ENTER:");
            try {
                Scanner scanNumber = new Scanner(System.in);
                userNumber = scanNumber.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Bad format" + '\n');
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
     * @return массив целочисленных начений
     */
    public static int[] getNumbersForArray(int arrayLength) {   // ввод чисел пользователем
        int[] arrOfNumbers;
        if (arrayLength > 0) {
            arrOfNumbers = new int[arrayLength];
            int userNumber;
            System.out.println("Type " + arrayLength + " numbers and press ENTER after each numeral");
            for (int i = 0; i < arrayLength; ) {
                try {
                    Scanner scan = new Scanner(System.in);
                    String userNumberString = scan.next();
                    userNumber = Integer.parseInt(userNumberString);
                } catch (NumberFormatException e) {
                    System.out.println("Bad format " + e);
                    System.out.println("\nType valid numbers and press ENTER after each numeral");
                    continue;
                }
                arrOfNumbers[i] = userNumber;
                i++;
            }
        } else {
            System.out.println("error 1");
            arrOfNumbers = new int[0];
        }
        return arrOfNumbers;
    }

    /**
     * Метод создает массив случайного размера (в пределах заданных
     * в переменных maxArrayLength и minArrayLength) случайными значениями
     * (в пределах minNumber и maxNumber)
     *
     * @return возвращаемый одномерный массив
     */
    public int[] createRandomArray() {
        int maxArrayLength = 10;
        int minArrayLength = 5;
        int minNumber = -10;
        int maxNumber = 10;
        int arrLength;
        int[] arr;

        arrLength = getRandomArrLength(minArrayLength, maxArrayLength);
        if (arrLength < 1) {
            System.out.println("Bad array length");
            return new int[0];
        }

        arr = getRandomArray(arrLength, minNumber, maxNumber);

        return arr;
    }

    /**
     * Метод получения случайного числа (в пределах переданных
     * в переменных min и max)
     *
     * @param min минимальное значение диапазона
     * @param max максимальное значение диапазона
     * @return возвращаемое значение
     */
    public int getRandomArrLength(int min, int max) {
        int length;
        int temp;

        if (min <= 0 || max <= 0 || max <= min) {
            System.out.println("Bad data of parameters");
            return 0;
        }
        temp = max - min + 1;
        length = (int) (Math.random() * temp) + min;
        return length;
    }

    /**
     * Метод создает массив размером arrayLength и  заполняет
     * случайными значениями (в пределах диапазона minNumber
     * и maxNumber)
     *
     * @param arrayLength размер создоваемого массива
     * @param minNumber минимальное значение диапазона
     * @param maxNumber максимальное значение диапазона
     * @return возвращаемый одномерный массив
     */
    int[] getRandomArray(int arrayLength, int minNumber, int maxNumber) {
        int[] arrWithRandomNumber;
        int range;

        if (arrayLength < 1) {
            System.out.println("Bad array length");
            return new int[0];
        }
        if (maxNumber <= minNumber) {
            System.out.println("Bad data of parameters");
            return new int[0];
        }

        arrWithRandomNumber = new int[arrayLength];
        range = maxNumber - minNumber + 1;

        for (int i = 0; i < arrWithRandomNumber.length; i++) {
            arrWithRandomNumber[i] = (int) (Math.random() * range) + minNumber;
        }
        return arrWithRandomNumber;
    }

    /**
     * Метод переворачивает одномерный массив целых чисел
     * @param arr массив для работы
     * @return возврашаемый массив
     */
    public static int[] reversArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        return arr;
    }

    public static String toString(Object[] a) {
         if (a == null) {
             return "null";
         }
         if (a.length == 0) {
             return "[]";
         }
         StringBuilder b = new StringBuilder();
         b.append('[');
         boolean isNull = true;
         for (int i = 0; ; i++) {
             if (a[i] == null) {
                 if (i == a.length-1) {
                     return b.append(']').toString();
                 }
                 isNull = true;
                 continue;
             }
             if (!isNull) {
                 b.append(", ");
             }
             b.append(String.valueOf(a[i]));
             if (i == a.length-1) {
                 return b.append(']').toString();
             }
             isNull = false;
         }
}
}
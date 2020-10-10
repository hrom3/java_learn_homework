package homework02;

import static homework02.ArraysMyVer2.getNumbersForArray;
import static homework02.ArraysMyVer2.getArrayLength;

public class Task2Sub3Ver2 {

    /*
     * 2.3 Вывести все элементы массива в консоль в обратном порядке.
     * Элементы массива вводить через консоль. Массив хранит в себе числа.
     * Выводить при помощи:
     *	2.3.1. do....while
     *	2.3.2. while
     *	2.3.3. for
     *	2.3.4. foreach
     */

    public static void main(String[] args) {
        int[] array;

        array = getNumbersForArray(getArrayLength());

        // Task 2.3.1
        System.out.println("Task 2.3.1");
        if (array.length > 0) {
            int i = array.length - 1;
            do {
                System.out.print(array[i] + " ");
                i--;
            } while (i >= 0);
            System.out.println('\n');
        }

        // Task 2.3.2
        System.out.println("Task 2.3.2");
        int i = array.length - 1;
        while (i >= 0) {
            System.out.print(array[i] + " ");
            i--;
        }
        System.out.println('\n');

        // Task 2.3.3
        System.out.println("Task 2.3.3");
        for (i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println('\n');

        // Task 2.3.4
        System.out.println("Task 2.3.4");
        int[] reversArr = ArraysMyVer2.reversArray(array);
        for (int elem : reversArr) {
            System.out.print(elem + " ");
        }
    }
}




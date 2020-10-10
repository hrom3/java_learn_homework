package homework02;

import static homework02.ArraysMyVer2.getNumbersForArray;
import static homework02.ArraysMyVer2.getArrayLength;

public class Task2Sub2Ver2 {
    /*
     * 2.2 Вывести каждый второй элемент массива в консоль. Элементы
     * массива вводить через консоль. Массив хранит в себе числа.
     * Выводить при помощи:
     *	2.1.1. do....while
     *	2.1.2. while
     *	2.1.3. for
     *	2.1.4. foreach.
     */


    public static void main(String[] args) {
        int[] array;

        array = getNumbersForArray(getArrayLength());

        // Task 2.2
        System.out.println("Task 2.2");
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println('\n');
    }
}



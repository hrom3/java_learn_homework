package homework02;


import homework02.task4classes.Task4_2ver3;
import homework02.task4classes.Task4_4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {

        // Task 4.4
        int[] arrOfNumber;
        int[] arrOfNumberBubbleSort;
        int[] arrOfNumberShakerSort;

        Task4_4 getArr = new Task4_4();
        arrOfNumber = getArr.createRandomArray();

        System.out.println("Random array\t\t  -> \t" +
                Arrays.toString(arrOfNumber));

        arrOfNumberBubbleSort = Task4_2ver3.bubbleSorter(arrOfNumber);
        arrOfNumberShakerSort = Task4_2ver3.shakerSorter(arrOfNumber);

        System.out.println("Sorted Array (bubble) -> \t" +
                Arrays.toString(arrOfNumberBubbleSort));
        System.out.println("Sorted Array (shaker) -> \t" +
                Arrays.toString(arrOfNumberShakerSort));
        System.out.println();

        // Task 4.5
        int arrLengthFromConsole;
        int[] arrFromConsole;
        int[] arrFromConsoleBubbleSort;
        int[] arrFromConsoleShakerSort;

        arrLengthFromConsole = Task2_1.getArrayLength();
        arrFromConsole = Task2_1.getNumbersOfArray(arrLengthFromConsole);

        System.out.println("Array from console\t  -> \t" +
                Arrays.toString(arrFromConsole));

        arrFromConsoleBubbleSort = Task4_2ver3.bubbleSorter(arrFromConsole);
        arrFromConsoleShakerSort = Task4_2ver3.shakerSorter(arrFromConsole);

        System.out.println("Sorted Array (bubble) -> \t" +
                Arrays.toString(arrFromConsoleBubbleSort));
        System.out.println("Sorted Array (shaker) -> \t" +
                Arrays.toString(arrFromConsoleShakerSort));
    }

}

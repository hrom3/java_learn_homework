package homework02;


import homework02.task4classes.Task4_2ver3;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {

        // Task 4.3
        int[] testArr1 = {1, 2, 3, 4, 5, 6};
        int[] testArr2 = {1, 1, 1, 1};
        int[] testArr3 = {9, 1, 5, 99, 9, 9};
        int[] testArr4 = {};
        int[] testArrMy = {4, 8, 33, -5, -965, 0};

        // Bubble sorting
        int[] sortTestArr1 = Task4_2ver3.bubbleSorter(testArr1);
        int[] sortTestArr2 = Task4_2ver3.bubbleSorter(testArr2);
        int[] sortTestArr3 = Task4_2ver3.bubbleSorter(testArr3);
        int[] sortTestArr4 = Task4_2ver3.bubbleSorter(testArr4);
        int[] sortTestArr5 = Task4_2ver3.bubbleSorter(testArrMy);

        // Shaker sorting
        int[] sortTestArr1S = Task4_2ver3.shakerSorter(testArr1);
        int[] sortTestArr2S = Task4_2ver3.shakerSorter(testArr2);
        int[] sortTestArr3S = Task4_2ver3.shakerSorter(testArr3);
        int[] sortTestArr4S = Task4_2ver3.shakerSorter(testArr4);
        int[] sortTestArr5S = Task4_2ver3.shakerSorter(testArrMy);

        System.out.println(Arrays.toString(testArr1) +
                " -> bubble " + Arrays.toString(sortTestArr1) +
                " -> shaker " + Arrays.toString(sortTestArr1S) + '\n');
        System.out.println(Arrays.toString(testArr2) +
                " -> bubble " + Arrays.toString(sortTestArr2) +
                " -> shaker " + Arrays.toString(sortTestArr2S) + '\n');
        System.out.println(Arrays.toString(testArr3) +
                " -> bubble " + Arrays.toString(sortTestArr3) +
                " -> shaker " + Arrays.toString(sortTestArr3S) + '\n');
        System.out.println(Arrays.toString(testArr4) +
                " -> bubble " + Arrays.toString(sortTestArr4) +
                " -> shaker " + Arrays.toString(sortTestArr4S) + '\n');
        System.out.println(Arrays.toString(testArrMy) +
                " -> bubble " + Arrays.toString(sortTestArr5) +
                " -> shaker " + Arrays.toString(sortTestArr5S) + '\n');


        // Task 4.4
        int[] arrOfNumber;
        int[] arrOfNumberBubbleSort;
        int[] arrOfNumberShakerSort;

        ArraysMy getArr = new ArraysMy();
        arrOfNumber = getArr.createRandomArray();
        arrOfNumberBubbleSort = Task4_2ver3.bubbleSorter(arrOfNumber);
        arrOfNumberShakerSort = Task4_2ver3.shakerSorter(arrOfNumber);

        System.out.println("Random array\t\t  -> \t" +
                Arrays.toString(arrOfNumber));
        System.out.println("Sorted Array (bubble) -> \t" +
                Arrays.toString(arrOfNumberBubbleSort));
        System.out.println("Sorted Array (shaker) -> \t" +
                Arrays.toString(arrOfNumberShakerSort));
        System.out.println();

        // Task 4.5
        int[] arrFromConsole;
        int[] arrFromConsoleBubbleSort;
        int[] arrFromConsoleShakerSort;

        arrFromConsole = ArraysMy.getNumbersForArray();
        arrFromConsoleBubbleSort = Task4_2ver3.bubbleSorter(arrFromConsole);
        arrFromConsoleShakerSort = Task4_2ver3.shakerSorter(arrFromConsole);

        System.out.println("Array from console\t  -> \t" +
                Arrays.toString(arrFromConsole));
        System.out.println("Sorted Array (bubble) -> \t" +
                Arrays.toString(arrFromConsoleBubbleSort));
        System.out.println("Sorted Array (shaker) -> \t" +
                Arrays.toString(arrFromConsoleShakerSort));
    }

}

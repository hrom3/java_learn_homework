package homework2;


import homework2.task4classes.Task4_2ver3;
import homework2.task4classes.Task4_4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] arrOfNumber;
        int[] arrOfNumberBubbleSort;
        int[] arrOfNumberShakerSort;

        Task4_4 getArr = new Task4_4();
        arrOfNumber = getArr.createRandomArray();

        System.out.println("Random array\t\t  -> \t" + Arrays.toString(arrOfNumber));

        arrOfNumberBubbleSort = Task4_2ver3.bubbleSorter(arrOfNumber);
        arrOfNumberShakerSort = Task4_2ver3.shakerSorter(arrOfNumber);

        System.out.println("Sorted Array (bubble) -> \t" +
                Arrays.toString(arrOfNumberBubbleSort));
        System.out.println("Sorted Array (shaker) -> \t" +
                Arrays.toString(arrOfNumberShakerSort));
    }

}

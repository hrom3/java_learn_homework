package homework02.task4classes;

import java.util.Arrays;

public class Task4_2ver2 {

    static void toSwap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Bubble sort of array
     *
     * @param array to sort
     * @return new sorted array
     */
    static int[] bubbleSorter(int[] array) {
        int[] sortArray = Arrays.copyOf(array, array.length);

        // check array.length
        if (sortArray.length < 2) {
            return sortArray;
        }
        for (int i = 0; i < sortArray.length; i++) {
            for (int j = sortArray.length - 1; j > i; j--) {
                if (sortArray[j] < sortArray[j - 1]) {
                    toSwap(sortArray, (j - 1), j);
                }
            }
        }
        return sortArray;
    }

    /**
     * Shaker sorting
     *
     * @param array to sort
     * @return new sorted array
     */
    static int[] shakerSorter(int[] array) {
        int[] sortArray = Arrays.copyOf(array, array.length);

        // check array.length
        if (sortArray.length < 2) {
            return sortArray;
        }

        int left = 0;
        int right = sortArray.length - 1;

        do {
            for (int i = left + 1; i <= right; i++) {
                if (sortArray[i] < sortArray[i - 1]) {
                    toSwap(sortArray, (i - 1), i);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (sortArray[i] < sortArray[i - 1]) {
                    toSwap(sortArray, (i - 1), i);
                }
            }
            left++;
        } while (left < right);
        return sortArray;
    }
}

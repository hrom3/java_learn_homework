package homework02.task4classes;

import java.util.Arrays;


public class Task4_2 {

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
                    int temp = sortArray[j - 1];
                    sortArray[j - 1] = sortArray[j];
                    sortArray[j] = temp;
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
        int temp;

        do {
            for (int i = left + 1; i <= right; i++) {
                if (sortArray[i] < sortArray[i - 1]) {
                    temp = sortArray[i - 1];
                    sortArray[i - 1] = sortArray[i];
                    sortArray[i] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (sortArray[i] < sortArray[i - 1]) {
                    temp = sortArray[i - 1];
                    sortArray[i - 1] = sortArray[i];
                    sortArray[i] = temp;
                }
            }
            left++;
        } while (left < right);
        return sortArray;
    }

    // method for test
    public static void main(String[] args) {
        int[] testArr1 = {1, 2, 3, 4, 5, 6};
        int[] testArr2 = {1, 1, 1, 1};
        int[] testArr3 = {9, 1, 5, 99, 9, 9};
        int[] testArr4 = {};
        int[] testArr5 = {4, 8, 33, -5, -965, 0};

        // Bubble sorting
        int[] sortTestArr1 = bubbleSorter(testArr1);
        int[] sortTestArr2 = bubbleSorter(testArr2);
        int[] sortTestArr3 = bubbleSorter(testArr3);
        int[] sortTestArr4 = bubbleSorter(testArr4);
        int[] sortTestArr5 = bubbleSorter(testArr5);

        // Shaker sorting
        int[] sortTestArr1S = shakerSorter(testArr1);
        int[] sortTestArr2S = shakerSorter(testArr2);
        int[] sortTestArr3S = shakerSorter(testArr3);
        int[] sortTestArr4S = shakerSorter(testArr4);
        int[] sortTestArr5S = shakerSorter(testArr5);

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
        System.out.println(Arrays.toString(testArr5) +
                " -> bubble " + Arrays.toString(sortTestArr5) +
                " -> shaker " + Arrays.toString(sortTestArr5S) + '\n');
    }
}
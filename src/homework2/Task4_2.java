package homework2;

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


    public static void main(String[] args) {
        int[] testArr1 = {1, 2, 3, 4, 5, 6};
        int[] testArr2 = {1, 1, 1, 1};
        int[] testArr3 = {9, 1, 5, 99, 9, 9};
        int[] testArr4 = {};
        int[] testArr5 = {4, 8, 33, -5, -965, 0};

        int[] sortTestArr1 = bubbleSorter(testArr1);
//        System.out.println(Arrays.toString(testArr1) + " -> " + Arrays.toString(sortTestArr1) + '\n');

        int[] sortTestArr2 = bubbleSorter(testArr2);
//        System.out.println(Arrays.toString(testArr2) + " -> " + Arrays.toString(sortTestArr2) + '\n');

        int[] sortTestArr3 = bubbleSorter(testArr3);
//        System.out.println(Arrays.toString(testArr3) + " -> " + Arrays.toString(sortTestArr3) + '\n');

        int[] sortTestArr4 = bubbleSorter(testArr4);
//        System.out.println(Arrays.toString(testArr4) + " -> " + Arrays.toString(sortTestArr4) + '\n');

        int[] sortTestArr5 = bubbleSorter(testArr5);
//        System.out.println(Arrays.toString(testArr5) + " -> " + Arrays.toString(sortTestArr5) + '\n');


        int[] sortTestArr1S = shakerSorter(testArr1);
        System.out.println(Arrays.toString(testArr1) + " -> " + Arrays.toString(sortTestArr1) + " -> " + Arrays.toString(sortTestArr1S) + '\n');

        int[] sortTestArr2S = shakerSorter(testArr2);
        System.out.println(Arrays.toString(testArr2) + " -> " + Arrays.toString(sortTestArr2) + " -> " + Arrays.toString(sortTestArr2S) + '\n');

        int[] sortTestArr3S = shakerSorter(testArr3);
        System.out.println(Arrays.toString(testArr3) + " -> " + Arrays.toString(sortTestArr3) + " -> " + Arrays.toString(sortTestArr3S) + '\n');

        int[] sortTestArr4S = shakerSorter(testArr4);
        System.out.println(Arrays.toString(testArr4) + " -> " + Arrays.toString(sortTestArr4) + " -> " + Arrays.toString(sortTestArr4S) + '\n');

        int[] sortTestArr5S = shakerSorter(testArr5);
        System.out.println(Arrays.toString(testArr5) + " -> " + Arrays.toString(sortTestArr5) + " -> " + Arrays.toString(sortTestArr5S) + '\n');
    }
}

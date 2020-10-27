package homework02.task4classes;

import java.util.Arrays;

public class Task4Sub2Ver4 {

    /*
     * Выполнить сортировку массива с числами:
     * 4.2. Пишем следующие алгоритмы:
     *  4.2.1. Пузырьковая сортировка
	 * 	4.2.2. Шейкерная сортировка
    */

    /**
     * Method to permute two elements in an array
     *
     * @param arr array
     * @param a   index number 1
     * @param b   index number 2
     */
    private static void toSwap(int[] arr, int a, int b) {
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
    public static void bubbleSorter(int[] array) {
       // check array.length
       if (array.length < 2) {
           return;
       }

       boolean isSort = false;
       int i = 0;

       while (!isSort) {
           isSort = true;
           for (int j = 0; j < (array.length - 1) - i; j++) {
               if (array[j] > array[j + 1]) {
                   toSwap(array, (j + 1), j);
                   isSort = false;
               }
           }
           i++;
       }
   }

    /**
     * Shaker sorting
     *
     * @param array to sort
     * @return new sorted array
     */
   public static void shakerSorter(int[] array) {

       // check array.length
       if (array.length < 2) {
           return;
       }

       int left = 0;
       int right = array.length - 1;

       do {
           for (int i = left + 1; i <= right; i++) {
               if (array[i] < array[i - 1]) {
                   toSwap(array, (i - 1), i);
               }
           }
           right--;
           for (int i = right; i > left; i--) {
               if (array[i] < array[i - 1]) {
                   toSwap(array, (i - 1), i);
               }
           }
           left++;
       } while (left < right);
   }
}
package homework02;

import static homework02.ArraysMy.getNumbersForArray;

public class Task2Sub3 {
    public static void main(String[] agrs) {
        int[] array;

        array = getNumbersForArray();

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
        int[] reversArr = ArraysMy.reversArray(array);
        for (int elem : reversArr) {
            System.out.print(elem + " ");
        }
    }
}




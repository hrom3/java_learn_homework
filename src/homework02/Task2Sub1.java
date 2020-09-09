package homework02;

import static homework02.ArraysMy.getNumbersForArray;


public class Task2Sub1 {
    public static void main(String[] agrs) {
        int[] array;

        array = getNumbersForArray();

        // Task 2.1.1
        System.out.println("Task 2.1.1");
        if (array.length > 0) {
            int i = 0;
            do {
                System.out.print(array[i] + " ");
                i++;
            } while (i < array.length);
            System.out.println('\n');
        }

        // Task 2.1.2
        System.out.println("Task 2.1.2");
        int i = 0;
        while (i < array.length) {
            System.out.print(array[i] + " ");
            i++;
        }
        System.out.println('\n');

        // Task 2.1.3
        System.out.println("Task 2.1.3");
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println('\n');

        // Task 2.1.4
        System.out.println("Task 2.1.4");
        for (int elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println('\n');
    }
}





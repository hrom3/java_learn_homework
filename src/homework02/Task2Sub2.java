package homework02;

import static homework02.ArraysMy.getNumbersForArray;

public class Task2Sub2 {
    public static void main(String[] agrs) {
        int[] array;

        array = getNumbersForArray();

        // Task 2.2
        System.out.println("Task 2.2");
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println('\n');
    }
}



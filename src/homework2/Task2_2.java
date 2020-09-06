package homework2;

public class Task2_2 {
    public static void main(String[] agrs) {
        int arrLength;
        int[] array;

        arrLength = Task2_1.getArrayLength();
        array = Task2_1.getNumbersOfArray(arrLength);

        // Task 2.2
        System.out.println("Task 2.2");
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println('\n');
    }
}



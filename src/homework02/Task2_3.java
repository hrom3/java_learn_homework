package homework02;

public class Task2_3 {
    public static void main(String[] agrs) {
        int arrLength;
        int[] array;

        arrLength = Task2_1.getArrayLength();
        array = Task2_1.getNumbersOfArray(arrLength);

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
        int[] reversArr = reversArray(array);
        for (int elem : reversArr) {
            System.out.print(elem + " ");
        }
        System.out.println('\n');
    }

    static int[] reversArray(int[] massive) {
        for (int i = 0; i < massive.length / 2; i++) {
            int tmp = massive[i];
            massive[i] = massive[massive.length - i - 1];
            massive[massive.length - i - 1] = tmp;
        }
        return massive;
    }
}




package homework02;


import homework02.task4classes.Task4Sub2Ver3;
import homework02.task4classes.Task4Sub2Ver4;

import java.util.Arrays;

public class Task4Ver2 {
    /*
     * Выполнить сортировку массива с числами:
	 * 4.0. !!!!ВНИМАНИЕ!!!! код сортировок в данном ДЗ не должен дублироваться.
	 * Дублирование кода сортировок приведёт к провалу выполнения данного
	 * задания. Итогом выполнения данного задания будет МАКСИМУМ 2 класса,
	 * может быть 1.
	 * 4.1. После каждой сортировки в консоли у вас должно получиться
	 * "[Какой массив был до сортировки] -> [Каким стал массив после сортировки]".
	 * Для вывода можно использовать Arrays.
	 * 4.3. Для тестов используем предварительно созданные массивы
	 * (в коде ваши тесты должны остаться):
	 * 	 4.3.1. {1,2,3,4,5,6}
	 * 	 4.3.2. {1,1,1,1}
	 * 	 4.3.3. {9,1,5,99,9,9}
	 * 	 4.3.4. {}
	 * 4.4. После тестов написать код который будет создавать массив рандомной
	 * длинны, заполнять массив рандомными числами
	 * 4.5. После рандома написать код который будет создавать массив руками
	 * через консоль
     */


    public static void main(String[] args) {

        // Task 4.3
        int[] testArr1 = {1, 2, 3, 4, 5, 6};
        int[] testArr2 = {1, 1, 1, 1};
        int[] testArr3 = {9, 1, 5, 99, 9, 9};
        int[] testArr4 = {};
        int[] testArrMy = {4, 8, 33, -5, -965, 0};

        // Bubble sorting
        int[] sortTestArr1 = Arrays.copyOf(testArr1, testArr1.length);
        int[] sortTestArr2 = Arrays.copyOf(testArr2, testArr2.length);
        int[] sortTestArr3 = Arrays.copyOf(testArr3, testArr3.length);
        int[] sortTestArr4 = Arrays.copyOf(testArr4, testArr4.length);
        int[] sortTestArr5 = Arrays.copyOf(testArrMy, testArrMy.length);

        Task4Sub2Ver4.bubbleSorter(sortTestArr1);
        Task4Sub2Ver4.bubbleSorter(sortTestArr2);
        Task4Sub2Ver4.bubbleSorter(sortTestArr3);
        Task4Sub2Ver4.bubbleSorter(sortTestArr4);
        Task4Sub2Ver4.bubbleSorter(sortTestArr5);

        System.out.println(Arrays.toString(testArr1) +
                " -> bubble " + Arrays.toString(sortTestArr1));
        System.out.println(Arrays.toString(testArr2) +
                " -> bubble " + Arrays.toString(sortTestArr2));
        System.out.println(Arrays.toString(testArr3) +
                " -> bubble " + Arrays.toString(sortTestArr3));
        System.out.println(Arrays.toString(testArr4) +
                " -> bubble " + Arrays.toString(sortTestArr4));
        System.out.println(Arrays.toString(testArrMy) +
                " -> bubble " + Arrays.toString(sortTestArr5));
        System.out.println("\n/_____________/");

        // Shaker sorting
        int[] sortTestArr1S = Arrays.copyOf(testArr1, testArr1.length);
        int[] sortTestArr2S = Arrays.copyOf(testArr2, testArr2.length);
        int[] sortTestArr3S = Arrays.copyOf(testArr3, testArr3.length);
        int[] sortTestArr4S = Arrays.copyOf(testArr4, testArr4.length);
        int[] sortTestArr5S = Arrays.copyOf(testArrMy, testArrMy.length);

        Task4Sub2Ver4.shakerSorter(sortTestArr1S);
        Task4Sub2Ver4.shakerSorter(sortTestArr2S);
        Task4Sub2Ver4.shakerSorter(sortTestArr3S);
        Task4Sub2Ver4.shakerSorter(sortTestArr4S);
        Task4Sub2Ver4.shakerSorter(sortTestArr5S);

        System.out.println(Arrays.toString(testArr1) +
                " -> shaker " + Arrays.toString(sortTestArr1S));
        System.out.println(Arrays.toString(testArr2) +
                " -> shaker " + Arrays.toString(sortTestArr2S));
        System.out.println(Arrays.toString(testArr3) +
                " -> shaker " + Arrays.toString(sortTestArr3S));
        System.out.println(Arrays.toString(testArr4) +
                " -> shaker " + Arrays.toString(sortTestArr4S));
        System.out.println(Arrays.toString(testArrMy) +
                " -> shaker " + Arrays.toString(sortTestArr5S));
        System.out.println("\n/_____________/");


        // Task 4.4
        int[] arrOfNumber;
        int[] arrOfNumberBubbleSort;
        int[] arrOfNumberShakerSort;

        ArraysMyVer2 getArr = new ArraysMyVer2();
        arrOfNumber = getArr.createRandomArray();
        arrOfNumberBubbleSort = Arrays.copyOf(arrOfNumber, arrOfNumber.length);
        arrOfNumberShakerSort = Arrays.copyOf( arrOfNumber, arrOfNumber.length);
        Task4Sub2Ver4.bubbleSorter(arrOfNumberBubbleSort);
        Task4Sub2Ver4.shakerSorter(arrOfNumberShakerSort);

        System.out.println("Random array\t\t  -> \t" +
                Arrays.toString(arrOfNumber));
        System.out.println("Sorted Array (bubble) -> \t" +
                Arrays.toString(arrOfNumberBubbleSort));
        System.out.println("Sorted Array (shaker) -> \t" +
                Arrays.toString(arrOfNumberShakerSort));

        System.out.println("\n/_____________/");

        // Task 4.5
        int[] arrFromConsole;
        int[] arrFromConsoleBubbleSort;
        int[] arrFromConsoleShakerSort;

        arrFromConsole = ArraysMy.getNumbersForArray();
        arrFromConsoleBubbleSort = Arrays.copyOf(arrFromConsole, arrFromConsole.length);
        arrFromConsoleShakerSort = Arrays.copyOf(arrFromConsole, arrFromConsole.length);
        Task4Sub2Ver4.bubbleSorter(arrFromConsoleBubbleSort);
        Task4Sub2Ver4.shakerSorter(arrFromConsoleShakerSort);

        System.out.println("Array from console\t  -> \t" +
                Arrays.toString(arrFromConsole));
        System.out.println("Sorted Array (bubble) -> \t" +
                Arrays.toString(arrFromConsoleBubbleSort));
        System.out.println("Sorted Array (shaker) -> \t" +
                Arrays.toString(arrFromConsoleShakerSort));
    }

}

package homework03;

public class Task2_Temp_CalculatorWithMemory {
    public static void main(String[] args) {
//        double a, b, c, d, e;
        int count;
        double result9;

        // Task 9
        CalculatorWithCounter task9 = new CalculatorWithCounter(2);

//        a = task9.division(28, 5);
//        b = task9.power(a, 2);
//        c = task9.multipl(15, 7);
//        d = task9.add(4.1, c);
//        e = task9.add(d, b);

        result9 = task9.add(task9.add(4.1, task9.multipl(15, 7)),
                task9.power(task9.division(28, 5), 2));
        count = task9.getCountOperation();

        System.out.printf("Result = %.3f\n", result9);
        System.out.println("Count of operations = " + count);
        System.out.println();
        System.out.println(task9.division(result9, 0));
        System.out.println(task9.division(result9, 0.0d));

    }
}

package homework03;

// Task 9
public class CalculatorWithCounterMain {
    public static void main(String[] args) {

        double result9;
        int count;

        // Set calculator type
        CalculatorWithCounter task9 = new CalculatorWithCounter(2);

        result9 = task9.add(task9.add(4.1, task9.multipl(15, 7)),
                task9.power(task9.division(28, 5), 2));
        count = task9.getCountOperation();

        System.out.printf("Result = %.3f\n", result9);
        System.out.println("Count of operations = " + count);
        System.out.println(task9.division(result9, 0));
        System.out.println(task9.division(result9, 0.0d));

    }
}

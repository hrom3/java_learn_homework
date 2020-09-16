package homework03;

// Task 11
public class CalculatorWithMemoryMain {
    public static void main(String[] args) {
        int count;
        double result11;

        CalculatorWithMemory task11 = new CalculatorWithMemory(1);

        task11.division(28, 5);
        task11.power(task11.getMemoryShort(), 2);
        task11.setMemoryLong();
        task11.multipl(15, 7);
        task11.add(4.1, task11.getMemoryShort());
        result11 = task11.add(task11.getMemoryShort(), task11.getMemoryLongAndErase());
        count = task11.getCountOperation();

        System.out.printf("Result = %.3f\n", result11);
        System.out.println("Count of operations = " + count);
        System.out.println();
        System.out.println(task11.division(result11, 0));
        System.out.println(task11.division(result11, 0.0d));

    }
}

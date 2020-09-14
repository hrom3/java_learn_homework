package homework03;

// Task 2
public class CalculatorWithOperatorMain {
    public static void main(String[] args) {
        double result;

        CalculatorWithOperator calc = new CalculatorWithOperator();

        result = calc.add(calc.add(4.1, calc.multipl(15, 7)),
                calc.power(calc.division(28, 5), 2));
        System.out.printf("Result = %.3f\n", result);

        // Task 2.1
        System.out.println(calc.division(result, 0));

        // Task 2.2
        System.out.println(calc.division(result, 0.0d));
    }
}
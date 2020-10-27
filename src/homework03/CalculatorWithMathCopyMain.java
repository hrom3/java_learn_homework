package homework03;

// Task 5 Повторить пункт 2 с классом CalculatorWithMathCopy

public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        double result5;

        CalculatorWithMathCopy task5 = new CalculatorWithMathCopy();

        result5 = task5.add(task5.add(4.1, task5.multipl(15, 7)),
                task5.power(task5.division(28, 5), 2));

        System.out.printf("Result = %.3f\n", result5);

        // Неявное приведение к double, результат бесонечность
        System.out.println(task5.division(result5, 0));

        // Результат бесонечность
        System.out.println(task5.division(result5, 0.0d));

    }
}

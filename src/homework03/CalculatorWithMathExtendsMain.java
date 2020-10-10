package homework03;

// Task 7 Повторить пункт 2 с классом CalculatorWithMathExtends

public class CalculatorWithMathExtendsMain {
    public static void main(String[] args) {
        double result7;

        CalculatorWithMathExtends task7 = new CalculatorWithMathExtends();

        result7 = task7.add(task7.add(4.1, task7.multipl(15, 7)),
                task7.power(task7.division(28, 5), 2));

        System.out.printf("Result = %.3f\n", result7);
        // Неявное приведение к double, результат бесонечность
        System.out.println(task7.division(result7, 0));
        // Результат бесонечность
        System.out.println(task7.division(result7, 0.0d));
    }
}

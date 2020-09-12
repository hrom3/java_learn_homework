package homework03;

public class Task2 {
    public static void main(String[] args) {
        CalculatorWithOperator calc = new CalculatorWithOperator();
        double a, b, c, d;
        double result;
        double result2_1;
        double result2_2;
        double resultVar2;
        double result5;
        double result7;

        a = calc.division(28, 5);
        b = calc.power(a, 2);
        c = calc.multipl(15, 7);
        d = calc.add(4.1, c);
        result = calc.add(d, b);
//        variant 2
//        resultVar2 = calc.add(calc.add(4.1, calc.multipl(15, 7)),
//                calc.power(calc.division(28, 5), 2));
        System.out.printf(String.format("Result = %.3f\n", result));

        result2_1 = calc.division(result, 0);
        result2_2 = calc.division(result, 0.0d);

        System.out.println(result2_1);
        System.out.println(result2_2);

        CalculatorWithMathCopy task5 = new CalculatorWithMathCopy();
        a = task5.division(28, 5);
        b = task5.power(a, 2);
        c = task5.multipl(15, 7);
        d = task5.add(4.1, c);
        result5 = task5.add(d, b);

        System.out.printf(String.format("Result = %.3f\n", result5));

        result2_1 = calc.division(result5, 0);
        result2_2 = calc.division(result5, 0.0d);

        System.out.println(result2_1);
        System.out.println(result2_2);

        CalculatorWithMathExtends task7 = new CalculatorWithMathExtends();
        a = task7.division(28, 5);
        b = task7.power(a, 2);
        c = task7.multipl(15, 7);
        d = task7.add(4.1, c);
        result7 = task7.add(d, b);

        System.out.printf(String.format("Result = %.3f\n", result7));

        result2_1 = calc.division(result7, 0);
        result2_2 = calc.division(result7, 0.0d);

        System.out.println(result2_1);
        System.out.println(result2_2);

    }
}

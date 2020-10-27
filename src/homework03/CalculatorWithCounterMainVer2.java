package homework03;

/*
 *  Task 9
 * Повторить пункт 2 с классом CalculatorWithCounter (помним что у нас
 * нет дефолтного констуктора). В конце программы необходимо вывести в
 * консоль инфомацию возвращаему методом getCountOperation().
 */

public class CalculatorWithCounterMainVer2 {
    public static void main(String[] args) {

        double result9;
        int count;

        // Set calculator type
        CalculatorWithCounterVer2 task9 = new CalculatorWithCounterVer2
                (new CalculatorWithOperator());

        result9 = task9.add(task9.add(4.1, task9.multipl(15, 7)),
                task9.power(task9.division(28, 5), 2));
        count = task9.getCountOperation();

        System.out.printf("Result = %.3f\n", result9);
        System.out.println("Count of operations = " + count);

        // Неявное приведение к double, результат бесонечность
        System.out.println(task9.division(result9, 0));

        // Результат бесонечность
        System.out.println(task9.division(result9, 0.0d));

    }
}

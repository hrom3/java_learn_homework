package homework03;

/*
 *  Task 2 В отдельном классе, создать мэйн метод. Внутри данного метода
 * создать экземпляр класса CalculatorWithOperator сохранив его в
 * переменную. При помощи методов созданного объекта вычислить результат
 * выражения 4.1 + 15 * 7 + (28 / 5) ^ 2. Результат записать в переменную
 * (определить самый подходящий тип переменной). Вывести сохранённый
 * результат в консоль. Внимание, знак "^" обозначает возведение в степень
 *  2.1 Далее сохранённый результат попробовать поделить на 0 (если
 * возникнет ошибка закомментировать и прокоментировать почему)
 *  2.2 Далее сохранённый результат попробовать поделить на 0.0d  (если
 * возникнет ошибка закомментировать и прокоментировать почему)
 */

public class CalculatorWithOperatorMain {
    public static void main(String[] args) {
        double result;

        CalculatorWithOperator calc = new CalculatorWithOperator();

        result = calc.add(calc.add(4.1, calc.multipl(15, 7)),
                calc.power(calc.division(28, 5), 2));
        System.out.printf("Result = %.3f\n", result);

        // Task 2.1
        // Неявное приведение к double, результат бесонечность
        System.out.println(calc.division(result, 0));

        // Task 2.2
        // Результат бесонечность
        System.out.println(calc.division(result, 0.0d));
    }
}
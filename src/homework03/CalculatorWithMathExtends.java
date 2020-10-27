package homework03;

/*  Task 3 Создать класс CalculatorWithMathCopy (скопировать базовые
 * математические операции из CalculatorWithOperator) и
 * CalculatorWithMathExtends (унаследовать базовые математические операции
 * из CalculatorWithOperator). Изучить библиотеку (класс) Math из jdk.
 * (https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
 *  Task 6. В классе CalculatorWithMathExtends должны присутствовать 4 метода
 * (деления, умножение, вычитание, сложение) данные методы нужно наследовать
 * из класса CalculatorWithOperator. В методах (Возведение в степень, Модуль
 * числа, Корень из числа) требуется переопределить и можно использовать только
 * вызовы  методов библиотеки Math, все методы в данном классе НЕ статические
 */

public class CalculatorWithMathExtends extends CalculatorWithOperator {

    @Override
    public double add(double first, double second) {
        return super.add(first, second);
    }

    @Override
    public double subtr(double first, double second) {
        return super.subtr(first, second);
    }

    @Override
    public double multipl(double first, double second) {
        return super.multipl(first, second);
    }

    @Override
    public double division(double first, double second) {
        return super.division(first, second);
    }

    @Override
    public double power(double base, int degree) {
        return Math.pow(base, degree);
    }

    @Override
    public double abs(double number) {
        return Math.abs(number);
    }

    @Override
    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}


package homework03;

public class CalculatorWithMathCopy {
    /**
     * Метод сложения 2 чисел
     *
     * @param first  первое слогаемое
     * @param second второе слогаемое
     * @return результат
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Метод вычитания 2 чисел
     *
     * @param first   уменьшаемое
     * @param second  вычитаемое
     * @return результат
     */
    public double subtr(double first, double second) {
        return first - second;
    }

    /**
     * Метод умножения 2 чисел
     *
     * @param first  множимое
     * @param second множитель
     * @return результат
     */
    public double multipl(double first, double second) {
        return first * second;
    }

    /**
     * Метод деления 2 чисел
     *
     * @param first  делимое
     * @param second делитель
     * @return результат
     */
    public double division(double first, double second) {
        return first / second;
    }

    /**
     * Метод возведения числа в степень
     *
     * @param base    число для возведения
     * @param degree  степень целой положительное число
     * @return  результат
     */
    public double power(double base, int degree) {
        return  Math.pow(base,degree);
    }

    /**
     * Метод получения модуля
     *
     * @param number число для получения модуля
     * @return модуль числа
     */
    public double abs(double number) {
        return Math.abs(number);
    }

    /**
     * Метод извлечения квадратного корня из числа
     *
     * @param number число для извлечения корня может
     * быть только положительным, отрицательное вернет NaN
     * @return корень числа
     */
    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}

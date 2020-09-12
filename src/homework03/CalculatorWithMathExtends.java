package homework03;

public class CalculatorWithMathExtends extends CalculatorWithOperator {
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

package homework03;

public class CalculatorWithOperator {

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
     * @return
     */
    public double power(double base, int degree) {
        double result = 1;
        if (base == 1) {
            return 1.0;
        }
        if (degree == 0) {
            return 0.0;
        }
        if (Double.isNaN(base) || Double.isInfinite(base)) {
            return Double.NaN;
        }
        for (int i = 0; i < degree; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * Метод получения модуля
     *
     * @param number число для получения модуля
     * @return модуль числа
     */
    public double abs(double number) {
        double result;
        result = number >= 0 ? number : -number;
        return result;
    }

    /**
     * Метод извлечения квадратного корня из числа
     *
     * @param number число для извлечения корня может
     * быть только положительным, отрицательное вернет NaN
     * @return корень числа
     */
    public double sqrt(double number) {
        if (number < 0) {
           return Double.NaN;
        }
        if (number == 0) {
            return 0;
        }
        double result;
        double newNumber = number;
        double oldResult;
        int newNumberInt;
        int nearNumberInSquare;
        int powOfTen = 0;
        boolean isEqual = false;

        // приводим заданое число к целому в диапазоне от 1 до 100 через степень 10
        if (newNumber >= 1) {
            while (newNumber >= 100) {
                newNumber /= 100;
                powOfTen++;
            }
        } else {
            while (newNumber < 1) {
                newNumber *= 100;
                powOfTen--;
            }
        }
        newNumberInt = (int) newNumber;

        // нахождение близкого большего основание для получения number
        if (newNumberInt < 4) {
            nearNumberInSquare = 2;
        } else if (newNumberInt < 9) {
            nearNumberInSquare = 3;
        } else if (newNumberInt < 16) {
            nearNumberInSquare = 4;
        } else if (newNumberInt < 25) {
            nearNumberInSquare = 5;
        } else if (newNumberInt < 36) {
            nearNumberInSquare = 6;
        } else if (newNumberInt < 49) {
            nearNumberInSquare = 7;
        } else if (newNumberInt < 64) {
            nearNumberInSquare = 8;
        } else {
            nearNumberInSquare = 9;
        }
        result = nearNumberInSquare * power(10., powOfTen);

        // получаем результат методом Ньютона
        for (int i = 0; i < 10 && !isEqual; i++) {
                oldResult = result;
                result = 0.5 * (result + (number / result));
                isEqual = oldResult == result;
            }
        return  result;
    }
}



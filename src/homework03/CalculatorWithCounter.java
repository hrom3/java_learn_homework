package homework03;

/*
 *  Task 8*. Создать класс CalculatorWithCounter, все методы в данном классе
 * НЕ статические. У данного класса должно быть три конструктора (или один
 * если сможете, это ещё не изучено
 * https://refactoring.guru/ru/design-patterns/decorator) один принимающий
 * в себя CalculatorWithOperator, второй CalculatorWithMathCopy, третий
 * CalculatorWithMathExtends. Данные конструкторы должны сохранять переданные
 * калькуляторы в приватные поля класса для дальнейшего их использования. Он
 * также имеет 7 методов как и другие калькуляторы + 1 метод getCountOperation()
 * который должен вернуть значение внутреннего счётчика.
 *  В реализации методов должен быть вызван один из объектов переданный в
 * констуктор при создании объекта CalculatorWithCounter, и вызвать
 * соответсвующий метод у них. К примеру. Если вызывают метод plus у
 * CalculatorWithCounter то он должен вызвать метод plus у объекта
 * CalculatorWithOperator или у объекта CalculatorWithMathCopy или у объекта
 * CalculatorWithMathExtends (смотря что передали в конструктор) и увеличить
 * значение внутреннего счётчика операций.
 */

public class CalculatorWithCounter implements ICalculator {
    private final ICalculator calcType;
    private int countOperation = 0;


    public CalculatorWithCounter(int calcType) {
        this.calcType = getCalculator(calcType);
    }

    public int getCountOperation() {
        return countOperation;
    }

    private ICalculator getCalculator(int type) {
        switch (type) {
            case 0:
                return new CalculatorWithOperator();
            case 1:
                return new CalculatorWithMathCopy();
            case 2:
            default:
                return new CalculatorWithMathExtends();
        }
    }

    public double add(double first, double second) {
        countOperation++;
        return calcType.add(first, second);
    }

    public double subtr(double first, double second) {
        countOperation++;
        return calcType.subtr(first, second);
    }

    public double multipl(double first, double second) {
        countOperation++;
        return calcType.multipl(first, second);
    }

    public double division(double first, double second) {
        countOperation++;
        return calcType.division(first, second);
    }

    public double power(double base, int degree) {
        countOperation++;
        return calcType.power(base, degree);
    }

    public double abs(double number) {
        countOperation++;
        return calcType.abs(number);
    }

    public double sqrt(double number) {
        countOperation++;
        return calcType.sqrt(number);
    }
}

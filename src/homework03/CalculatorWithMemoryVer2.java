package homework03;

/*
 *  Task 10* Создать CalculatorWithMemory, принципы как и в задании 9, сможете)?.
 * Данный калькулятор работает как настоящий калькулятор с функцией памяти.
 * Функция памяти работает через два метода, записать в память результат
 * выполнения последнего вызванного метода, получить из памяти записанное
 * значение. При получении записи из памяти память стирается, при записи
 * нового значения память перезаписывается.
 */

public class CalculatorWithMemoryVer2 implements ICalculator {
    private final ICalculator calcType;
    private int count = 0;
    private double memoryShort = Double.NaN;
    private double memoryLong = Double.NaN;

    public CalculatorWithMemoryVer2(ICalculator calcType) {
       this.calcType = calcType;
    }

    public double getMemoryShort() {
        return memoryShort;
    }

    public double getMemoryLongAndErase() {
        double temp = memoryLong;
        this.memoryLong = Double.NaN;
        return temp;
    }

    public void setMemoryLong() {
        this.memoryLong = memoryShort;
    }

    public int getCountOperation() {
        return count;
    }

    @Override
    public double add(double first, double second) {
        count++;
        memoryShort = calcType.add(first, second);
        return memoryShort;
    }

    @Override
    public double subtr(double first, double second) {
        count++;
        memoryShort = calcType.subtr(first, second);
        return memoryShort;
    }

    @Override
    public double multipl(double first, double second) {
        count++;
        memoryShort = calcType.multipl(first, second);
        return memoryShort;
    }

    @Override
    public double division(double first, double second) {
        count++;
        memoryShort = calcType.division(first, second);
        return memoryShort;
    }

    @Override
    public double power(double base, int degree) {
        count++;
        memoryShort = calcType.power(base, degree);
        return memoryShort;
    }

    @Override
    public double abs(double number) {
        count++;
        memoryShort = calcType.abs(number);
        return memoryShort;
    }

    @Override
    public double sqrt(double number) {
        count++;
        memoryShort = calcType.sqrt(number);
        return memoryShort;
    }
}

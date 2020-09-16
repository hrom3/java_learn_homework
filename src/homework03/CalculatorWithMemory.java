package homework03;

// Task 10
public class CalculatorWithMemory extends CalculatorWithCounter{
    private double memoryShort = .0;
    private double memoryLong = .0;

    public CalculatorWithMemory(int calcType) {
        super(calcType);
    }

    public double getMemoryShort() {
        return memoryShort;
    }

    public double getMemoryLongAndErase() {
        double temp = memoryLong;
        this.memoryLong = .0;
        return temp;
    }

    public void setMemoryLong() {
        this.memoryLong = memoryShort;
    }

    @Override
    public int getCountOperation() {
        return super.getCountOperation();
    }

    @Override
    public double add(double first, double second) {
        memoryShort = super.add(first, second);
        return memoryShort;
    }

    @Override
    public double subtr(double first, double second) {
        memoryShort = super.subtr(first, second);
        return memoryShort;
    }

    @Override
    public double multipl(double first, double second) {
        memoryShort = super.multipl(first, second);
        return memoryShort;
    }

    @Override
    public double division(double first, double second) {
        memoryShort = super.division(first, second);
        return memoryShort;
    }

    @Override
    public double power(double base, int degree) {
        memoryShort = super.power(base, degree);
        return memoryShort;
    }

    @Override
    public double abs(double number) {
        memoryShort = super.abs(number);
        return memoryShort;
    }

    @Override
    public double sqrt(double number) {
        memoryShort = super.sqrt(number);
        return memoryShort;
    }
}

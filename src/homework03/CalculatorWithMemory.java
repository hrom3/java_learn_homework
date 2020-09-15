package homework03;
// Task 10
public class CalculatorWithMemory extends CalculatorWithCounter{
    private double memory = Double.NaN;

    public double getMemoryAndErase() {
        double temp = memory;
        this.memory = Double.NaN;
        return temp;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    @Override
    public int getCountOperation() {
        return super.getCountOperation();
    }

    public CalculatorWithMemory(int calcType) {
        super(calcType);
    }

}

package homework03;
// Task 10
public class CalculatorWithMemory extends CalculatorWithCounter{
    private double memory = .0;

    public double getMemoryAndErase() {
        double temp = memory;
        this.memory = .0;
        return temp;
    }

//    memorylong
//    memoryShort
//    void memory()

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

package homework03;

//Task 8
public class CalculatorWithCounter implements ICalculator {
    private int countOperation = 0;
    private CalculatorWithOperator calcOper = new CalculatorWithOperator();
    private CalculatorWithMathCopy calcCopy = new CalculatorWithMathCopy();
    private CalculatorWithMathExtends calcExt = new CalculatorWithMathExtends();
    private ICalculator calcType;

    public CalculatorWithCounter(int calcType) {
        this.calcType = getCalculator(calcType);
    }

    public int getCountOperation() {
        return countOperation;
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

    private ICalculator getCalculator(int type) {
        switch (type) {
            case 0:
                return calcOper;
            case 1:
                return calcCopy;
            case 2:
            default:
                return calcExt;
        }
    }
}

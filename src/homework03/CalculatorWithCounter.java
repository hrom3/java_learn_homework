package homework03;

public class CalculatorWithCounter {
    private int countOperation = 0;
    private CalculatorWithOperator calcOper = new CalculatorWithOperator();
    private CalculatorWithMathCopy calcCopy = new CalculatorWithMathCopy();
    private CalculatorWithMathExtends calcExt = new CalculatorWithMathExtends();

    public int getCountOperation() {
        return countOperation;
    }

    public double add(double first, double second) {
        countOperation++;
        return calcOper.add(first, second);
    }

    public double subtr(double first, double second) {
        countOperation++;
        return calcCopy.subtr(first, second);
    }

    double multipl(double first, double second) {
        countOperation++;
        return calcExt.multipl(first, second);
    }
    double division(double first, double second) {
        countOperation++;
        return calcExt.division(first, second);
    }

    double power(double base, int degree) {
        countOperation++;
        return calcCopy.power(base, degree);
    }

    double abs(double number) {
        countOperation++;
        return calcOper.abs(number);
    }

    double sqrt(double number) {
        countOperation++;
        return calcExt.sqrt(number);
    }

//    public static ICalculator getCalculator(int type) {
//        switch (type) {
//            case 1:
//                return new CalculatorWithOperator();
//            case 0:
//                return new CalculatorWithMathCopy();
//            case -1:
//            default:
//                return new CalculatorWithMathExtends();
//        }
//    }

}

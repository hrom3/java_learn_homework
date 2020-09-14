package homework03;

// Task 3 Task 4
public class CalculatorWithMathExtends extends CalculatorWithOperator {

    @Override
    public double add(double first, double second) {
        return super.add(first, second);
    }

    @Override
    public double subtr(double first, double second) {
        return super.subtr(first, second);
    }

    @Override
    public double multipl(double first, double second) {
        return super.multipl(first, second);
    }

    @Override
    public double division(double first, double second) {
        return super.division(first, second);
    }

    @Override
    public double power(double base, int degree) {
        return Math.pow(base,degree);
    }

    @Override
    public double abs(double number) {
        return Math.abs(number);
    }

    @Override
    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}


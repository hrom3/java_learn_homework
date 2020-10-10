package homework03;

/*
 *  Все калькуляторы и выбор через ENUM
 */

public class CalculatorAllMain {

    private ECalcType calcType;

    public static void main(String[] args) {
        int count;
        double resultCalcMem;
        ECalcType calcType = ECalcType.CALC_WITH_COPY;

        workWithCalcs(getCalculator(ECalcType.CALC_WITH_OPERATOR));
        workWithCalcs(getCalculator(ECalcType.CALC_WITH_EXTENDS));
        workWithCalcs(getCalculator(calcType));


        CalculatorWithMemoryVer2 calcMem = new CalculatorWithMemoryVer2(getCalculator(calcType));

        calcMem.power(calcMem.division(28, 5), 2);
        calcMem.setMemoryLong();
        calcMem.add(4.1, calcMem.multipl(15, 7));
        resultCalcMem = calcMem.add(calcMem.getMemoryShort(), calcMem.getMemoryLongAndErase());
        count = calcMem.getCountOperation();

        System.out.printf("Result = %.3f\n", resultCalcMem);
        System.out.println("Count of operations = " + count);
        System.out.println();

        CalculatorWithCounterVer2 calcCount = new CalculatorWithCounterVer2(getCalculator(calcType));
        double resultCalcCount = calcCount.add(calcCount.add(4.1, calcCount.multipl(15, 7)),
                calcCount.power(calcCount.division(28, 5), 2));
        int countCalcCount = calcCount.getCountOperation();

        System.out.printf("Result = %.3f\n", resultCalcCount);
        System.out.println("Count of operations = " + count);
        System.out.println();

    }

    private static ICalculator getCalculator(ECalcType calcType) {
        switch (calcType) {
            case CALC_WITH_OPERATOR:
                return new CalculatorWithOperator();
            case CALC_WITH_EXTENDS:
                return new CalculatorWithMathExtends();
            case CALC_WITH_COPY:
            default:
                return new CalculatorWithMathCopy();
        }
    }

    private static void workWithCalcs(ICalculator calc) {
        double result = calc.add(calc.add(4.1, calc.multipl(15, 7)),
                calc.power(calc.division(28, 5), 2));
        System.out.println(calc.getClass().getName());
        System.out.printf("Result = %.3f\n", result);
        System.out.println();

    }

}

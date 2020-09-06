package homework2;

public class Task1_5 {
    public static void main(String[] args) {
        int startNumberInFirstColumn = 2;
        int endNumberInLAstColumn = 9;
        int columnsInRow = 4;
        int firstNumeralToMult = 1;
        int lastNumeralToMult = 9;
        int rows = 0;

        if (startNumberInFirstColumn > endNumberInLAstColumn ||
                firstNumeralToMult > lastNumeralToMult) {
            System.out.println("Bad data");
            return;
        }
        System.out.println();
        System.out.println( "\t \t \t Таблица умножения");
        rows = (int) Math.ceil((double) (endNumberInLAstColumn -
                startNumberInFirstColumn + 1) / columnsInRow);
        for (int i = 0, j = 1; i < rows; i++, j++) {
            int start = startNumberInFirstColumn + (columnsInRow * i);
            int end = startNumberInFirstColumn - 1 + (columnsInRow * j);
            if ((startNumberInFirstColumn - 1 + (columnsInRow * j) <
                    endNumberInLAstColumn))
            {
                columns(start, end, firstNumeralToMult, lastNumeralToMult);
            } else {
                columns(start, endNumberInLAstColumn, firstNumeralToMult,
                        lastNumeralToMult);
            }
            System.out.println();
        }


    }

    // method of columns construction
    static void columns(int startNumber, int endNumber, int firstMultiplier,
                        int lastMultiplier) {
        for (int i = firstMultiplier; i <= lastMultiplier; i++) {
            for (int j = startNumber; j <= endNumber; j++) {
                System.out.print(j + " x " + i + " = " + (j * i) + '\t');
            }
            System.out.println();
         }
    }
}

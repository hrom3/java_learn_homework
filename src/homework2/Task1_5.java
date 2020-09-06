package homework2;

public class Task1_5 {
    public static void main(String[] args) {
        int startNumber = 2;
        int endNumber = 9;
        int columnsInRow = 4;
        int firstNumeralToMult = 1;
        int lastNumeralToMult = 9;
        int rows = 0;
        int startNumberInRow;
        int endNumberInRow;

        if (startNumber > endNumber
                || firstNumeralToMult > lastNumeralToMult) {
            System.out.println("Bad data");
            return;
        }
        System.out.println();
        System.out.println("\t \t \t Таблица умножения");
        rows = (int) Math.ceil((double) (endNumber -
                startNumber + 1) / columnsInRow);
        for (int i = 0, j = 1; i < rows; i++, j++) {
            startNumberInRow = startNumber + (columnsInRow * i);
            endNumberInRow = Math.min(startNumber - 1 + (columnsInRow * j),
                    endNumber);

            columns(startNumberInRow, endNumberInRow, firstNumeralToMult,
                    lastNumeralToMult);
            System.out.println();
        }


    }

    // method of columns construction
    static void columns(int startNumberInRow, int endNumberInRow,
                        int firstMultiplier, int lastMultiplier) {
        for (int i = firstMultiplier; i <= lastMultiplier; i++) {
            for (int j = startNumberInRow; j <= endNumberInRow; j++) {
                System.out.print(j + " x " + i + " = " + (j * i) + '\t');
            }
            System.out.println();
        }
    }
}

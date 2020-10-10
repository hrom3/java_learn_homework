package homework02;

public class Task1Sub5 {

    /*
    * Вывести таблицу умножения в консоль. В консоли должно получиться
    * также как и на картинке (динозаврика рисовать не надо):
    * https://www.dropbox.com/s/ibakfuppvy2w32g/multiplication_table.jpeg?dl=0
    */

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
        System.out.println("\t \t \t Таблица умножения\n");
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

    /**
     * Метод построения строки таблицы умножения
     * 
     * @param startNumberInRow
     * @param endNumberInRow
     * @param firstMultiplier
     * @param lastMultiplier
     */
    static void columns(int startNumberInRow, int endNumberInRow,
                        int firstMultiplier, int lastMultiplier) {
        for (int i = firstMultiplier; i <= lastMultiplier; i++) {
            for (int j = startNumberInRow; j <= endNumberInRow; j++) {
                System.out.printf("%d x %d = %d\t", j, i, (j * i));
            }
            System.out.println();
        }
    }
}

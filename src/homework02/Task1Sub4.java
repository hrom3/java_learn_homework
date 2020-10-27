package homework02;

public class Task1Sub4 {

    /*
     * 1.4.* Умножать число long a = 1; на 3 пока не произойдёт переполнение.
     * В конце в консоль вывести сообщение со значением до переполнения и
     * после переполнения
     */

    public static void main(String[] args) {
        long a = 1;
        long aPrevious = 0;
        long factor = 3;
        boolean isOverflow = false;
        while (!isOverflow) {
            aPrevious = a;
            for (int i = 1; i < factor ; i++) {
                if (willAdditionOverflow(aPrevious, a)) {
                    isOverflow = true;
                }
                a += aPrevious;
            }
        }
        System.out.println("Long before overflow = " + aPrevious +
                " and after overflow = " + a);
    }

    /**
     * Метод проверки на переполнение при сложении
     *
     * @param left первое слогаемое
     * @param right второе слогаемое
     * @return возвращаемое значение, если истина то переполнение наступило,
     * иначе не было переполнения
     */
    public static boolean willAdditionOverflow(long left, long right) {
        if (right < 0 && right != Long.MIN_VALUE) {
            return willSubtractionOverflow(left, -right);
        } else {
            // проверка на старший бит
            return (~(left ^ right) & (left ^ (left + right))) < 0;
        }
    }

    /**
     * Метод проверки на переполнение при вычитании
     *
     * @param left первое уменьшаемое
     * @param right второе вычитаемое
     * @return возвращаемое значение, если истина то переполнение наступило,
     * иначе не было переполнения
     */
    public static boolean willSubtractionOverflow(long left, long right) {
        if (right < 0) {
            return willAdditionOverflow(left, -right);
        } else {
            // проверка на старший бит (но здесь результат XOR не инвертируется)
            return ((left ^ right) & (left ^ (left - right))) < 0;
        }
    }
}

package homework02;

public class Task1_4 {
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
        System.out.println("Long before overflow = " + aPrevious + " and after overflow = " + a);
    }

    public static boolean willAdditionOverflow(long left, long right) {
        if (right < 0 && right != Long.MIN_VALUE) {
            return willSubtractionOverflow(left, -right);
        } else {
            return (~(left ^ right) & (left ^ (left + right))) < 0;
        }
    }

    public static boolean willSubtractionOverflow(long left, long right) {
        if (right < 0) {
            return willAdditionOverflow(left, -right);
        } else {
            return ((left ^ right) & (left ^ (left - right))) < 0;
        }
    }
}

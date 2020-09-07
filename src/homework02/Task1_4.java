package homework02;

public class Task1_4 {
    public static void main(String[] args) {
        long a = 1;
        long aPrevious = 0;
        long factor = 3;
        int i = 0;
        while (a >= 0) {
            aPrevious = a;
            a *= factor;
        }
        System.out.println("Long before overflow = " + aPrevious + " and after overflow = " + a);
    }
}

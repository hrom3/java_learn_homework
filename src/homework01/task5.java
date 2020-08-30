package homework01;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ввведите имя: ");
        String name = in.nextLine();

        Task5EqualIf.isEqual(name);
        System.out.println();
        Task5EqualIfElse.isEqual(name);
        System.out.println();
        Task5Switch.isEqual(name);
    }
}

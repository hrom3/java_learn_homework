package homework01;

import java.util.Objects;

class Task5EqualIf {
    static void isEqual(String str) {
        String vasia = "Вася";
        String nastia = "Анастасия";
        boolean isVasia;
        boolean isNastia;

        isVasia = Objects.equals(vasia, str);
        isNastia = Objects.equals(nastia, str);
        if (!isNastia && !isVasia) {
            System.out.println("Добрый день,  Вы кто?");
        }
        if (isVasia) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
        }
        if (isNastia) {
            System.out.println("Я тебя так долго ждал");
        }
    }

}

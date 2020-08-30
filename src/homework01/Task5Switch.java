package homework01;

import java.util.Objects;

class Task5Switch {
    static void isEqual(String str) {
        switch (str) {
            case "Вася":
                System.out.println("Привет!");
            case "Анастасия":
                System.out.println("Я тебя так долго ждал");
                break;
            default:
                System.out.println("Добрый день,  Вы кто?");
        }
    }
}

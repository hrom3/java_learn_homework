package homework01;

import java.util.Objects;
import java.util.Scanner;

class Task5SwitchVer2 {
    public static void main(String[] args) {

        /*
         * Разбираемся с операторами ветвления.
         * 5.1 Используя статью https://metanit.com/java/tutorial/2.9.php
         *   запросить у пользователя его имя.
         * 5.2 Если имя будет равно имени Вася тогда в консоль должно вывести
         *   сообщение "Привет!" на одной строке, а на второй "Я тебя так долго ждал".
         * 5.3 Если имя будет равно имени "Анастасия" тогда в консоль должно
         *   вывести сообщение "Я тебя так долго ждал".
         * 5.4 В случае если это будет другое имя то вывести сообщение
         *    "Добрый день, а вы кто?".
         * 5.7 Написать сравнение в отдельном классе при помощи switch
         */

        Scanner in = new Scanner(System.in);
        System.out.print("Ввведите имя: ");

        String name = in.nextLine();

        switch (name) {
            case "Вася":
                System.out.println("Привет!");
            case "Анастасия":
                System.out.println("Я тебя так долго ждал");
                break;
            default:
                System.out.println("Добрый день, а Вы кто?");
                break;
        }
    }
}

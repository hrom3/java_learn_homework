package homework01;

import java.util.Objects;
import java.util.Scanner;

class Task5EqualIfElseVer2 {
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
         * 5.6 Написать сравнение в отдельном классе при помощи else if
         * 5.8 В примерах if и else if для сравнения имён использовать код
         *   вида Objects.equals("Имя1", "Имя2").
         */

        String friend = "Вася";
        String girlfriend = "Анастасия";
        Scanner in = new Scanner(System.in);

        System.out.print("Ввведите имя: ");

        String name = in.nextLine();
        boolean isFriend = Objects.equals(friend, name);
        boolean isGirlfriend = Objects.equals(girlfriend, name);

        if (isFriend) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
        } else if (isGirlfriend) {
            System.out.println("Я тебя так долго ждал");
        } else {
            System.out.println("Добрый день, а Вы кто?");
        }
    }
}

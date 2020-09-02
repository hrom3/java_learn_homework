package homework01;

import java.util.Objects;

class Task5EqualIfVer2 {
    static void isEqual(String str) {
        String friend = "Вася";
        String girlfriend = "Анастасия";
        boolean isFriend;
        boolean isGirlfriend;

        isFriend = Objects.equals(friend, str);
        isGirlfriend = Objects.equals(girlfriend, str);

        if (isFriend) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
            return;
        }
        if (isGirlfriend) {
            System.out.println("Я тебя так долго ждал");
            return;
        }
        System.out.println("Добрый день, а Вы кто?");
    }
}
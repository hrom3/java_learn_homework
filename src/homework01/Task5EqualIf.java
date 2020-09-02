package homework01;

import java.util.Objects;

class Task5EqualIf {
    static void isEqual(String str) {
        String friend = "Вася";
        String girlfriend = "Анастасия";
        boolean isFriend;
        boolean isGirlfriend;

        isFriend = Objects.equals(friend, str);
        isGirlfriend = Objects.equals(girlfriend, str);
        if (!isGirlfriend && !isFriend) {
            System.out.println("Добрый день, а Вы кто?");
        }
        if (isFriend) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
        }
        if (isGirlfriend) {
            System.out.println("Я тебя так долго ждал");
        }
    }

}

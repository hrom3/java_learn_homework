package homework01;

public class task4 {
    public static void main(String[] arg) {
        boolean isWeekday = true;
        boolean isVacation = true;

        if (sleepIn(isWeekday, isVacation)) {
            System.out.println("You can sleep");
        } else {
            System.out.println("It's time to wake up!");
        }
    }

    static boolean sleepIn(boolean weekday, boolean vacation) {
        boolean isCanSleep = false;

        if (!weekday || vacation) {
            isCanSleep = true;
        }
        return isCanSleep;
    }
}

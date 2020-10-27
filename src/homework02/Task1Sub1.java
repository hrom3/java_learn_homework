package homework02;


public class Task1Sub1 {

    /* 1.1. Перемножить числа от 1 до числа (включительно) введенного
     * через аргумент к исполняемой программе. Пример: Ввели 5, должно
     * получиться в консоли: 1 * 2 * 3 * 4 * 5 = ответ
     * 1.2. Все цифры из числа введенного через аргумент к исполняемой
     * программе перемножить между собой и вывести ход вычислений в консоль.
     * Пример: Ввели 181232375, должно получиться в консоли:
     * 1 * 8 * 1 * 2 * …. * 5 = ответ
     */

    public static void main(String[] args) {
        int argumLength = args.length;
        long userNumber = 0;
        long multip = 1;
        StringBuilder str = new StringBuilder();
        str.append(1);

        if (args.length == 0) {
            System.out.println("The program is launched with no arguments");
            return;
        }

        if (argumLength > 1) {
            System.out.println("The program is launched with more than 1 argument." +
                    " Only the first argument will be used");
        }

        try {
            userNumber = Long.parseLong(args[0]);
            if (userNumber > 0 && userNumber < 22) {
                for (int i = 2; i <= userNumber; i++) {
                    multip *= i;
                    str.append(" * ");
                    str.append(i);
                }
                System.out.println(str + " = " + multip);
            } else if (userNumber >= 22) {
                System.out.println("Argument is more than 21. " +
                        "The program cannot calculate this");
            } else {
                System.out.println("Argument is less than 1");
            }
        } catch (NumberFormatException e) {
            System.out.println("Bad format of argument " + e);
        }
    }
}

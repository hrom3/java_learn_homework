package homework02;

public class Task1Sub2 {
    public static void main(String[] args) {
        int argumLength = args.length;
        long userNumber = 0;
        long multip = 1;
        String[] userNumberArr;
        String userNumberStr;
        int userNumberLength;
        int userNumberNumeral;

        if (args.length == 0) {
            System.out.println("The program is launched with no arguments");
            return;
        }
        if (argumLength > 1) {
            System.out.println("The program is launched with more than 1 argument. " +
                    "Only the first argument will be used");
        }
        try {
            userNumber = Long.parseLong(args[0]);
            userNumberLength = CountNumeralsInNumber.lengthOfNumber(userNumber);
            userNumberArr = new String[userNumberLength];
            for (int i = userNumberLength - 1; i >= 0; i--) {
                userNumberNumeral = (int) (userNumber % 10);
                userNumber /= 10;
                multip *= userNumberNumeral;
                userNumberArr[i] = String.valueOf(userNumberNumeral);
            }
            userNumberStr = String.join(" x ", userNumberArr);
            userNumberStr = userNumberStr + " = " + multip;
            System.out.println(userNumberStr);
        } catch (NumberFormatException e) {
            System.out.println("Bad format of argument " + e);
        }
    }
}

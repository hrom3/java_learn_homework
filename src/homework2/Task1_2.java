package homework2;

public class Task1_2 {
    public static void main(String[] args) {
        int argumLength = args.length;
        long userNumber = 0;
        long multip = 1;
        String[] userNumberArr;
        String userNumberStr;
        int userNumberLength;
        int userNumberNumeral;
        boolean isExept = false;

        if (args.length > 0) {
            if (argumLength > 1) {
                System.out.println("The program is launched with more than 1 argument. Only the first argument will be used");
            }
            try {
                userNumber = Long.parseLong(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Bad format of argument " + e);
                isExept = true;
            }
            if (!isExept) {
                userNumberLength = lengthOfNumber(userNumber);
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
            }
        } else {
            System.out.println("The program is launched with no arguments");
        }
    }

    static int lengthOfNumber(long number) {
        int length;
        long modNumber = Math.abs(number);
        if (modNumber != 0) {
            length = (int) Math.log10(modNumber) + 1;
        } else {
            length = 1;
        }
        return length;
    }
}

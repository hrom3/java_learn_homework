package homework2;

public class Task1_1 {
    public static void main(String[] args) {
        int argumLength = args.length;
        long userNumber = 0;
        long multip = 1;
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
                if (userNumber > 1 && userNumber < 22){
                    for (int i = 1; i <= userNumber; i++) {
                        multip *= i;
                    }
                    System.out.println("Result = " + multip);
                } else if (userNumber >= 22) {
                    System.out.println("Argument is more than 21. The program cannot calculate this");
                } else {
                    System.out.println("Argument is less than 1");
                }
            }
        } else {
            System.out.println("The program is launched with no arguments");
        }
    }
}

package homework01;

public class Task6Ver2 {
    public static void main(String[] args) {
        int[] phoneNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String formattedPhoneNumber;

        formattedPhoneNumber = createPhoneNumber(phoneNumber);
        System.out.println(formattedPhoneNumber);
    }

    static String createPhoneNumber(int[] number) {
        String formatNumber = String.format("(%d%d%d) %d%d%d-%d%d%d%d", number[0], number[1], number[2],
                number[3], number[4], number[5], number[6], number[7], number[8],number[9]);
        return formatNumber;
    }
}

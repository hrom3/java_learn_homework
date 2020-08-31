package homework01;

public class Task6 {
    public static void main(String[] args) {
        int[] phoneNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String formattedPhoneNumber;

        formattedPhoneNumber = createPhoneNumber(phoneNumber);
        System.out.println(formattedPhoneNumber);
    }

    static String createPhoneNumber(int[] number) {
        String formatNumber;
        char[] arrNumber = new char[14];

        for (int i = 0, n = 0; i < 14; i++) {
            if (i == 0) {
                arrNumber[i] = '(';
            } else if (i == 4) {
                arrNumber[i] = ')';

                arrNumber[++i] = ' ';
            } else if (i == 9) {
                arrNumber[i] = '-';
            } else {
                arrNumber[i] = (char) ('0' + number[n]); // добавить код '0' чтобы получить в char число
                n++;
            }
        }
        formatNumber = new String(arrNumber);
        return formatNumber;
    }
}

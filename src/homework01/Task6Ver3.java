package homework01;

public class Task6Ver3 {

    /*
     * Создать СТАТИЧЕСКИЙ метод createPhoneNumber рядом с методом main, данный
     * метод будет принимает один параметр и будет возвращать строку в
     * отформатированном виде. В метод будет передаваться массив из 10 цифр
     * (от 0 до 9). Данные цифры должны быть помещены в строку формата:
     * (XXX) XXX-XXXX. Например передан массив: {1,2,3,4,5,6,7,8,9,0},
     * возвращаемый результат: (123) 456-7890.
     * (Взято с https://www.codewars.com/kata/525f50e3b73515a6db000b83/train/java)
     */

    public static void main(String[] args) {
        Integer[] phoneNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String formattedPhoneNumber = createPhoneNumber(phoneNumber);
        System.out.println(formattedPhoneNumber);
    }

    static String createPhoneNumber(Integer... number) {
        if (number == null) {
            return "No data";
        }
        if (number.length != 10) {
            return "Bad array";
        }
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", number);
    }
}

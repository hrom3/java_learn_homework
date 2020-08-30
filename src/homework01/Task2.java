package homework01;

public class Task2 {
     public static void main(String[] args) {
         int two = 2;
         int eight = 8;
         int result1;
         int result2;
         int result3;
         int result4;
         int result5;
         int result6;
         int result7Bad;
         boolean result8;
         boolean result9;

         result1 = 5 + two / eight; // result = 5: 2/8=0, 5+0=5
         result2 = (5 + two) / eight; // result = 0: 5+2=7, 7/8=0
         result3 = (5 + two++) / eight; // result = 0, two=3: 5+2=7, 7/8=0
         two = 2;
         result4 = (5 + two++) / --eight; // result = 1, two=3, eight=7: 5+2=7, 8-1=7, 7/7=1
         two = 2;
         eight = 8;
         result5 = (5 * two >> two++) / --eight; // result = 0, two=3, eight=7: 5*2=10,
         // 10 -> BIN 1010 >> 2 = 0010 -> DEC 2, 8-1=7, 2/7=0
         two = 2;
         eight = 8;
         result6 = (5 + 7 > 20 ? 68 : 22 * two >> two++) / --eight;  // result = 1, two=3, eight=7: 5 + 7 > 20 = false
         // -> 22 * two >> two++: 22*2=44 -> 0010 1100 >> 2 = 1011 -> DEC 11; 8-1=7, 11/7=1
         two = 2;
         eight = 8;
//         result7Bad = (5 + 7 > 20 ? 68 >= 68 : 22 * two >> two++) / --eight;  // ошибка компиляции тернарный опреатор
         // в данном выражениие может вернуть, или boolean, или int который затем делится на int, что невозможно.
         result8 = 6 - two > 3 && 12 * 12 <= 119; // result = false: 6 - two > 3 -> true, 12 * 12 <= 119 -> false,
         // true && false = false
         result9 = true && false; // result = false

         System.out.println(result1);
         System.out.println(result2);
         System.out.println(result3);
         System.out.println(result4);
         System.out.println(result5);
         System.out.println(result6);
         System.out.println(result8);
         System.out.println(result9);
     }
}

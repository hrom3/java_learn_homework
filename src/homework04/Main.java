package homework04;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntComparator intComparator = new IntComparator();
        NumberComparator numComparator = new NumberComparator();
        StringComparator strComparator = new StringComparator();

//        String
        DataContainer<String> str1 = new DataContainer<>(new String[13]);
        System.out.println(str1.toString());
        str1.addData("jeep");
        str1.addData("audi");
        str1.addData("bmw");
        str1.addData("lada");
        System.out.println("Add value \"belazla\" = index " + str1.addData("belazla"));
        str1.addData("kia");
        str1.addData("honda");
        str1.addData("opel");
        str1.addData("a");
        System.out.println(str1.toString());
        System.out.println(str1.toString());
        System.out.println("Get index 14 = " + str1.get(14));
        System.out.println("Get index 2 = " + str1.get(2));
        System.out.println("Get index 6 = " + str1.get(6));
        System.out.println();

        String[] arrayStr = str1.getItems();

        System.out.println("Before sorting " + Arrays.toString(arrayStr));

        str1.sort(strComparator);

        System.out.println("After  sorting " + Arrays.toString(str1.getItems()));
        System.out.println("Delete index -5 = " + str1.delete(-5));
        System.out.println("Delete index 15 = " + str1.delete(15));
        System.out.println("Delete index 4 = " + str1.delete(4));
        System.out.println(str1.toString());
        System.out.println("Delete index 8 = " + str1.delete(8));
        System.out.println(str1.toString());
        System.out.println("Delete value \"belazla\" = " + str1.delete("belazla"));
        System.out.println(str1.toString());
        System.out.println("Delete value \"opel\" = " + str1.delete("opel"));
        System.out.println(str1.toString());
        System.out.println("Delete value \"Integer\" = " + str1.delete("Integer"));
        System.out.println(str1.toString());
        System.out.println("Delete value null = " + str1.delete(null));
        System.out.println(str1.toString());
        System.out.println("With null " + Arrays.toString(str1.getItems()) + "\n\n");

//      Integer
        DataContainer<Integer> int1 = new DataContainer<>(new Integer[12]);

        System.out.println(int1.toString());

        int1.addData(1);
        int1.addData(2);
        int1.addData(3);

        System.out.println("Add value 77 = index " + int1.addData(77));

        int1.addData(4);
        int1.addData(null);
        int1.addData(5);
        int1.addData(6);
        int1.addData(null);
        int1.addData(7);
        int1.addData(8);

        System.out.println(int1.toString());
        System.out.println("Get index 77 = " + int1.get(77));
        System.out.println("Get index 2 = " + int1.get(2));
        System.out.println("Get index 6 = " + int1.get(6));
        System.out.println();

        Integer[] array = int1.getItems();

        System.out.println("Before sorting " + Arrays.toString(array));

        int1.sort(intComparator);

        System.out.println("After  sorting " + Arrays.toString(int1.getItems()));
        System.out.println("Delete index -5 = " + int1.delete(-5));
        System.out.println(int1.toString());
        System.out.println("Delete index 15 = " + int1.delete(9));
        System.out.println(int1.toString());
        System.out.println("Delete index 4 = " + int1.delete(4));
        System.out.println(int1.toString());
        System.out.println("Delete index 2 = " + int1.delete(2));
        System.out.println(int1.toString());
        System.out.println("Delete value 8 = " + int1.delete(Integer.valueOf(8)));
        System.out.println(int1.toString());
        System.out.println("Delete value 3 = " + int1.delete(Integer.valueOf(3)));
        System.out.println(int1.toString());
        System.out.println("Delete value 77 = " + int1.delete(Integer.valueOf(77)));
        System.out.println(int1.toString());
        System.out.println("Delete value null = " + int1.delete(null));
        System.out.println(int1.toString());
        System.out.println("With null " + Arrays.toString(int1.getItems()) + "\n\n");

//      Number
        DataContainer<Number> number1 = new DataContainer<>(new Number[12]);

        System.out.println(number1.toString());

        number1.addData(56.2);
        number1.addData(296.3);
        number1.addData(3.4);

        System.out.println("Add data 0.77 = index " + number1.addData(0.77));

        number1.addData(4L);
        number1.addData(null);
        number1.addData(null);
        number1.addData(null);
        number1.addData(555.0);
        number1.addData(6);
        number1.addData(7);
        number1.addData(null);
        number1.addData(85.4);

        System.out.println(number1.toString());

        System.out.println("Get index 77 = " + number1.get(77));
        System.out.println("Get index -1 = " + number1.get(-1));
        System.out.println("Get index 2 = " + number1.get(2));
        System.out.println("Get index 6 = " + number1.get(6));
        System.out.println();

        Number[] arrayNum = number1.getItems();

        System.out.println("Before sorting " + Arrays.toString(arrayNum));

        number1.sort(numComparator);

        System.out.println("After  sorting " + Arrays.toString(number1.getItems()));
        System.out.println("Delete index -5 = " + number1.delete(-5));
        System.out.println(number1.toString());
        System.out.println("Delete index 15 = " + number1.delete(15));
        System.out.println(number1.toString());
        System.out.println("Delete index 4 = " + number1.delete(4));
        System.out.println(number1.toString());
        System.out.println("Delete index 2 = " + number1.delete(2));
        System.out.println(number1.toString());
        System.out.println("Delete value 8.4 = " + number1.delete(85.4));
        System.out.println(number1.toString());
        System.out.println("Delete value 3 = " + number1.delete(Integer.valueOf(3)));
        System.out.println(number1.toString());
        System.out.println("Delete value 0.77 = " + number1.delete(0.77));
        System.out.println(number1.toString());
        System.out.println("Delete value null = " + number1.delete(null));
        System.out.println(number1.toString());
        System.out.println("With null " + Arrays.toString(number1.getItems()) + "\n\n");


    }


}

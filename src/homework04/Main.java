package homework04;

public class Main {
    public static void main(String[] args) {
//        DataContainer2 itm = new DataContainer2();
//        System.out.println(itm.toString());
        DataContainer<String> str1 = new DataContainer<>(new String[1]);
        System.out.println(str1.toString());
        str1.addData("ghtr");
        str1.addData("efszfs");
        str1.addData("fefef");
        str1.addData("gfefefsr");
        System.out.println(str1.toString());

        DataContainer<Integer> int1 = new DataContainer<>(new Integer[6]);
        System.out.println(int1.toString());
        int1.addData(1);
        int1.addData(2);
        int1.addData(3);
        System.out.println(int1.addData(77));
        System.out.println(int1.toString());

        System.out.println(int1.get(77));
        System.out.println(int1.get(-1));
        System.out.println(int1.get(2));
        System.out.println(int1.get(6));

    }




}

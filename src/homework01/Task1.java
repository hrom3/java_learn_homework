package homework01;

public class Task1 {
    public static void main(String[] args){
       int numberA = 42;    //0000 0000 0000 0000 0000 0000 0010 1010
       int numberB = 15;    //0000 0000 0000 0000 0000 0000 0000 1111
       int numberC = -42;   //1111 1111 1111 1111 1111 1111 1101 0110
       int numberD = -15;   //1111 1111 1111 1111 1111 1111 1111 0001
       int numberE = 3;     //0000 0000 0000 0000 0000 0000 0000 0011
       int numberF;

       numberF = ~numberA; //result 1111 1111 1111 1111 1111 1111 1101 0101
        System.out.println(numberF); // DEC -43
       numberF = ~numberB; //result 1111 1111 1111 1111 1111 1111 1111 0000
        System.out.println(numberF); // DEC -16
       numberF = numberA & numberB; //result 0000 0000 0000 0000 0000 0000 0000 1010
        System.out.println(numberF); // DEC 10
       numberE &= numberA; //0000 0000 0000 0000 0000 0000 0000 0010
        System.out.println(numberE); // DEC 2
       numberE &= numberB; //0000 0000 0000 0000 0000 0000 0000 0010
        System.out.println(numberE); // DEC 2
       numberF = numberA | numberB; //result 0000 0000 0000 0000 0000 0000 0010 1111
        System.out.println(numberF); // DEC 47
       numberE |= numberA; //0000 0000 0000 0000 0000 0000 0010 1010
        System.out.println(numberE); // DEC 42
       numberE |= numberB; //0000 0000 0000 0000 0000 0000 0010 1111
        System.out.println(numberE); // DEC 47
       numberF = numberA ^ numberB; //result 0000 0000 0000 0000 0000 0000 0010 0101
        System.out.println(numberF); // DEC 37
       numberE ^= numberA; //0000 0000 0000 0000 0000 0000 0000 0101
        System.out.println(numberE); // DEC 5
       numberE ^= numberB; //0000 0000 0000 0000 0000 0000 0000 1010
        System.out.println(numberE); // DEC 10
       numberF = numberA >> 3;//result 0000 0000 0000 0000 0000 0000 0000 0101
        System.out.println(numberF); // DEC 5
       numberF = numberB >> 3;//result 0000 0000 0000 0000 0000 0000 0000 0001
        System.out.println(numberF); // DEC 1
       numberF = numberA;
       numberF >>=2; //result 0000 0000 0000 0000 0000 0000 0000 1010
        System.out.println(numberF); // DEC 10
       numberF = numberB;
       numberF >>=2; //result 0000 0000 0000 0000 0000 0000 0000 0011
        System.out.println(numberF); // DEC 3
       numberF = numberA >>> 3;//result 0000 0000 0000 0000 0000 0000 0000 0101
        System.out.println(numberF); // DEC 5
       numberF = numberB >>> 3;//result 0000 0000 0000 0000 0000 0000 0000 0001
        System.out.println(numberF); // DEC 1
       numberF = numberA;
       numberF >>>=2; //result 0000 0000 0000 0000 0000 0000 0000 1010
        System.out.println(numberF); // DEC 10
       numberF = numberB;
       numberF >>>=2; //result 0000 0000 0000 0000 0000 0000 0000 0011
        System.out.println(numberF); // DEC 3

        System.out.println();
        System.out.println(numberF); // DEC 3
        System.out.println(numberE); //result DEC 10
       numberF = numberB >> 3;//result 0000 0000 0000 0000 0000 0000 0010 0101
                System.out.println(numberF); // DEC 37
       System.out.println(numberB >> 3); //result 0000 0000 0000 0000 0000 0000 0010 0101, DEC 37

       System.out.println(~numberC); //result 0000 0000 0000 0000 0000 0000 0010 1001, DEC 41
       System.out.println(~numberD); //result 1111 1111 1111 1111 1111 1111 0000 1110, DEC 14
       System.out.println(numberC & numberD); //result 1111 1111 1111 1111 1111 1111 1101 0000, DEC -48

       numberC &= numberD; //1111 1111 1111 1111 1111 1111 1101 0110
       numberD &= numberE; //1111 1111 1111 1111 1111 1111 1111 0001


        // c = 1111 1111 1111 1111 1111 1111 1101 0110
        // d = 1111 1111 1111 1111 1111 1111 1111 0001

       System.out.println(numberC); //result DEC -42
       System.out.println(numberD); //result DEC -15
       System.out.println(numberC | numberD); //result 1111 1111 1111 1111 1111 1111 1101 0000, DEC -48

       numberE |= numberC; //1111 1111 1111 1111 1111 1111 1111 1111
       numberE |= numberD; //1111 1111 1111 1111 1111 1111 1111 1111

       System.out.println(numberA); //result DEC 42
       System.out.println(numberB); //result DEC 15
       System.out.println(numberC); //result DEC -42
       System.out.println(numberD); //result DEC -15

       System.out.println("~42=" + numberA + "; ~15=" + numberB + "; ~-42=" + numberC + "; ~-42=" + numberD);
    }
}

package homework01;

public class task1 {
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
       numberF = numberA << 5;//result 0000 0000 0000 0000 0000 0101 0100 0000
        System.out.println(numberF); // DEC 1344
       numberF = numberB << 5;//result 0000 0000 0000 0000 0000 0001 1110 0000
        System.out.println(numberF); // DEC 480
       numberF = numberA;
        numberF <<=2; //result 0000 0000 0000 0000 0000 0000 1010 1000
        System.out.println(numberF); // DEC 168
       numberF = numberB;
       numberF <<=2; //result 0000 0000 0000 0000 0000 0000 0011 1100
        System.out.println(numberF); // DEC 60
        System.out.println();

        System.out.println(numberE); //result 0000 0000 0000 0000 0000 0000 1010, DEC 10


        numberF = ~numberC; //result 0000 0000 0000 0000 0000 0000 0010 1001
        System.out.println(numberF); // DEC 41
        numberF = ~numberD; //result 0000 0000 0000 0000 0000 0000 0000 1110
        System.out.println(numberF); // DEC 14
        numberF = numberC & numberD; //1111 1111 1111 1111 1111 1111 1101 0000
        System.out.println(numberF); // DEC -48
        numberE &= numberC; //0000 0000 0000 0000 0000 0000 0000 0010
        System.out.println(numberE); // DEC 2
        numberE &= numberD; //0000 0000 0000 0000 0000 0000 0000 0000
        System.out.println(numberE); // DEC 0
        numberF = numberC | numberD; //result 1111 1111 1111 1111 1111 1111 1111 0111
        System.out.println(numberF); // DEC -9
        numberE |= numberC; //1111 1111 1111 1111 1111 1111 1101 0110
        System.out.println(numberE); // DEC -42
        numberE |= numberD; //1111 1111 1111 1111 1111 1111 1111 0111
        System.out.println(numberE); // DEC -9
        numberF = numberC ^ numberD; //result 0000 0000 0000 0000 0000 0000 0010 0111
        System.out.println(numberF); // DEC 39
        numberE ^= numberC; //0000 0000 0000 0000 0000 0000 0010 0001
        System.out.println(numberE); // DEC 33
        numberE ^= numberD; //1111 1111 1111 1111 1111 1111 1101 0000
        System.out.println(numberE); // DEC -48
        numberF = numberC >> 3;//result 1111 1111 1111 1111 1111 1111 1111 1010
        System.out.println(numberF); // DEC -6
        numberF = numberD >> 3;//result 1111 1111 1111 1111 1111 1111 1111 1110
        System.out.println(numberF); // DEC -2

        System.out.println();

        numberF = numberC;
        numberF >>= 2; //result 1111 1111 1111 1111 1111 1111 1111 0101
        System.out.println(numberF); // DEC -11
        numberF = numberD;
        numberF >>= 4; //result 1111 1111 1111 1111 1111 1111 1111 1111
        System.out.println(numberF); // DEC -1
        numberF = numberC >>> 20;//result 0000 0000 0000 0000 0000 1111 1111 1111
        System.out.println(numberF); // DEC 4095
        numberF = numberD >>> 26;//result 0000 0000 0000 0000 0000 0000 0011 1111
        System.out.println(numberF); // DEC 63
        numberF = numberC;
        numberF >>>= 31; //result 0000 0000 0000 0000 0000 0000 0000 0001
        System.out.println(numberF); // DEC 1
        numberF = numberD;
        numberF >>>= 22; //result 0000 0000 0000 0000 0000 0011 1111 1111
        System.out.println(numberF); // DEC 1023
        numberF = numberC << 4;//result 1111 1111 1111 1111 1111 1101 0110 0000
        System.out.println(numberF); // DEC -672
        numberF = numberD << 5;//result 1111 1111 1111 1111 1111 1110 0010 0000
        System.out.println(numberF); // DEC -480
        numberF = numberC;
        numberF <<= 2; //result 1111 1111 1111 1111 1111 1111 0101 1000
        System.out.println(numberF); // DEC -168
        numberF = numberD;
        numberF <<= 3; //result 1111 1111 1111 1111 1111 1111 1000 1000
        System.out.println(numberF); // DEC -120
    }
}

package homework01;

public class Task1 {

    /*
     * Побитовые операции:
     * 1.1. http://developer.alexanderklimov.ru/android/java/bitwise.php
     * 1.2 Использовать ВСЕ возможные побитовые операции с числами 42 и 15.
     * 1.3 Использовать ВСЕ возможные побитовые операции с числами -42 и -15.
     * 1.4 В комментариях к каждой операции написать двоичный код каждого числа
     * и результата операции.
     */

    public static void main(String[] args) {
        int numberA = 42;    //0000 0000 0000 0000 0000 0000 0010 1010
        int numberB = 15;    //0000 0000 0000 0000 0000 0000 0000 1111
        int numberC = -42;   //1111 1111 1111 1111 1111 1111 1101 0110
        int numberD = -15;   //1111 1111 1111 1111 1111 1111 1111 0001
        int numberE = 3;     //0000 0000 0000 0000 0000 0000 0000 0011
        int numberF;

        // Операции с числами 42 и 15
        // Операция побитовое НЕ
        numberF = ~numberA; //result 1111 1111 1111 1111 1111 1111 1101 0101
        numberF = ~numberB; //result 1111 1111 1111 1111 1111 1111 1111 0000

        // Операция побитовое И
        numberF = numberA & numberB; //result 0000 0000 0000 0000 0000 0000 0000 1010
        numberE &= numberA; //0000 0000 0000 0000 0000 0000 0000 0010
        numberE &= numberB; //0000 0000 0000 0000 0000 0000 0000 0010

        // Операция побитовое ИЛИ
        numberF = numberA | numberB; //result 0000 0000 0000 0000 0000 0000 0010 1111
        numberE |= numberA; //0000 0000 0000 0000 0000 0000 0010 1010
        numberE |= numberB; //0000 0000 0000 0000 0000 0000 0010 1111

        // Операция побитовое исключ. ИЛИ
        numberF = numberA ^ numberB; //result 0000 0000 0000 0000 0000 0000 0010 0101
        numberE ^= numberA; //0000 0000 0000 0000 0000 0000 0000 0101
        numberE ^= numberB; //0000 0000 0000 0000 0000 0000 0000 1010

        // Операция сдвиг вправо
        numberF = numberA >> 3; //result 0000 0000 0000 0000 0000 0000 0000 0101
        numberF = numberB >> 3; //result 0000 0000 0000 0000 0000 0000 0000 0001
        numberF = numberA;
        numberF >>= 2; //result 0000 0000 0000 0000 0000 0000 0000 1010
        numberF = numberB;
        numberF >>= 2; //result 0000 0000 0000 0000 0000 0000 0000 0011

        // Операция сдвиг вправо без учета знакового бита
        numberF = numberA >>> 3; //result 0000 0000 0000 0000 0000 0000 0000 0101
        numberF = numberB >>> 3; //result 0000 0000 0000 0000 0000 0000 0000 0001
        numberF = numberA;
        numberF >>>= 2; //result 0000 0000 0000 0000 0000 0000 0000 1010
        numberF = numberB;
        numberF >>>= 2; //result 0000 0000 0000 0000 0000 0000 0000 0011

        // Операция сдвиг влево (эквивлентно умножению на 2)
        numberF = numberA << 5; //result 0000 0000 0000 0000 0000 0101 0100 0000
        numberF = numberB << 5; //result 0000 0000 0000 0000 0000 0001 1110 0000
        numberF = numberA;
        numberF <<= 2; //result 0000 0000 0000 0000 0000 0000 1010 1000
        numberF = numberB;
        numberF <<= 2; //result 0000 0000 0000 0000 0000 0000 0011 1100

        // Операции с числами -42 и -15
        // Операция побитовое НЕ
        numberF = ~numberC; //result 0000 0000 0000 0000 0000 0000 0010 1001
        numberF = ~numberD; //result 0000 0000 0000 0000 0000 0000 0000 1110

        // Операция побитовое И
        numberF = numberC & numberD; //1111 1111 1111 1111 1111 1111 1101 0000
        numberE &= numberC; //0000 0000 0000 0000 0000 0000 0000 0010
        numberE &= numberD; //0000 0000 0000 0000 0000 0000 0000 0000

        // Операция побитовое ИЛИ
        numberF = numberC | numberD; //result 1111 1111 1111 1111 1111 1111 1111 0111
        numberE |= numberC; //1111 1111 1111 1111 1111 1111 1101 0110
        numberE |= numberD; //1111 1111 1111 1111 1111 1111 1111 0111

        // Операция побитовое исключ. ИЛИ
        numberF = numberC ^ numberD; //result 0000 0000 0000 0000 0000 0000 0010 0111
        numberE ^= numberC; //0000 0000 0000 0000 0000 0000 0010 0001
        numberE ^= numberD; //1111 1111 1111 1111 1111 1111 1101 0000

        // Операция сдвиг вправо
        numberF = numberC >> 3; //result 1111 1111 1111 1111 1111 1111 1111 1010
        numberF = numberD >> 3; //result 1111 1111 1111 1111 1111 1111 1111 1110
        numberF = numberC;
        numberF >>= 2; //result 1111 1111 1111 1111 1111 1111 1111 0101
        numberF = numberD;
        numberF >>= 4; //result 1111 1111 1111 1111 1111 1111 1111 1111

        // Операция сдвиг вправо без учета знакового бита
        numberF = numberC >>> 20; //result 0000 0000 0000 0000 0000 1111 1111 1111
        numberF = numberD >>> 26; //result 0000 0000 0000 0000 0000 0000 0011 1111
        numberF = numberC;
        numberF >>>= 31; //result 0000 0000 0000 0000 0000 0000 0000 0001
        numberF = numberD;
        numberF >>>= 22; //result 0000 0000 0000 0000 0000 0011 1111 1111

        // Операция сдвиг влево (эквивлентно умножению на 2)
        numberF = numberC << 4; //result 1111 1111 1111 1111 1111 1101 0110 0000
        numberF = numberD << 5; //result 1111 1111 1111 1111 1111 1110 0010 0000
        numberF = numberC;
        numberF <<= 2; //result 1111 1111 1111 1111 1111 1111 0101 1000
        numberF = numberD;
        numberF <<= 3; //result 1111 1111 1111 1111 1111 1111 1000 1000
    }
}

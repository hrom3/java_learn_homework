package homework2.task4classes;

public class Task4_4 {

    public int[] createRandomArray() {
        int maxArrayLength = 10;
        int minArrayLength = 5;
        int minNumber = -10;
        int maxNumber = 10;
        int arrLength;
        int[] arr;

        arrLength = getArrLength(minArrayLength, maxArrayLength);
        if (arrLength < 1) {
            System.out.println("Bad array length");
            return new int[0];
        }

        arr = getRandomArray(arrLength, minNumber, maxNumber);

        return arr;
    }

    int getArrLength(int min, int max) {
        int length;
        int temp;

        if (min <= 0 || max <= 0 || max <= min) {
            System.out.println("Bad data of parameters");
            return 0;
        }
        temp = max - min + 1;
        length = (int) (Math.random() * temp) + min;
        return length;
    }

    int[] getRandomArray(int arrayLength, int minNumber, int maxNumber) {
        int[] arrWithRandomNumber;
        int range;

        if (arrayLength < 1) {
            System.out.println("Bad array length");
            return new int[0];
        }
        if (maxNumber <= minNumber) {
            System.out.println("Bad data of parameters");
            return new int[0];
        }

        arrWithRandomNumber = new int[arrayLength];
        range = maxNumber - minNumber + 1;

        for (int i = 0; i < arrWithRandomNumber.length; i++) {
            arrWithRandomNumber[i] = (int) (Math.random() * range) + minNumber;
        }
        return arrWithRandomNumber;
    }
}


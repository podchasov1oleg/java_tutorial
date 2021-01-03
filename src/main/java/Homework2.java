import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        //1.
        byte[] array1 = new byte[]{1, 0, 1, 1, 0, 0, 1, 1, 1, 0};
        System.out.println(Arrays.toString(reverseBinaryArray(array1)));

        //2.
        byte[] array2 = new byte[8];
        for (byte val = 0, cnt = 0; cnt < array2.length; val += 3, cnt++) {
            array2[cnt] = val;
        }
        System.out.println(Arrays.toString(array2));

        //3.
        byte[] array3 = new byte[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            array3[i] = array3[i] < 6 ? (byte) (array3[i] * 2) : array3[i];
        }
        System.out.println(Arrays.toString(array3));

        //4.
        int[][] matrix = new int[10][10];
        int diagonalIndex = 0;

        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], 0);
            for (int n = 0; n < matrix[i].length; n++) {
                if (n == diagonalIndex) matrix[i][n] = 1;
            }
            System.out.println(Arrays.toString(matrix[i]));
            diagonalIndex++;
        }

        //5.
        int[] minMax = new int[]{94, -42, 12, 30, -95, -20, 47, -38, 94, 9};
        int minVal = 0, maxVal = 0;
        for (int element : minMax) {
            minVal = Math.min(element, minVal);
            maxVal = Math.max(element, maxVal);
        }
        System.out.printf("Минимальное число: %d, максимальное: %d", minVal, maxVal);

        //6.
        System.out.println();
        int[] array6_1 = new int[]{1, 1, 1, 2, 1}; //true
        int[] array6_2 = new int[]{2, 2, 2, 1, 2, 2, 10, 1}; //true
        int[] array6_3 = new int[]{2, 4, 8, 16, 32, 64, 128, 256, 512}; // false
        int[] array6_4 = new int[]{2, 2, 4, 8, 16, 32, 64, 128, 256, 512}; //true

        System.out.println(checkBalance(array6_1));
        System.out.println(checkBalance(array6_2));
        System.out.println(checkBalance(array6_3));
        System.out.println(checkBalance(array6_4));

        //7.
        int[] array7_1 = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.toString(offsetArray(array7_1, -2)));
        System.out.println(Arrays.toString(offsetArray(array7_1, 2)));
    }

    private static byte[] reverseBinaryArray(byte[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) (array[i] ^ 1);
        }

        return array;
    }

    private static boolean checkBalance(int[] array) {
        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];
            int rightSum = 0;
            for (int n = i + 1; n < array.length; n++) {
                rightSum += array[n];
            }
            if (rightSum == leftSum) return true;
        }

        return false;
    }

    private static int[] offsetArray(int[] array, int offset) {
        int min, max;
        if (offset == 0) {
            return array;
        } else if (offset > 0) {
            min = 0;
            max = array.length - 1;
        } else {
            min = array.length - 1;
            max = 0;
        }

        for (int n = 0; n < Math.abs(offset); n++) {
            int buffer = 0;
            for (int i = min; (min == 0) && (i <= max) || (min > 0) && (i >= max);) {
                if (i == min) {
                    buffer = array[i];
                    array[i] = array[max];
                } else if (i != max) {
                    buffer += array[i];
                    array[i] = buffer - array[i];
                    buffer -= array[i];
                } else {
                    array[i] = buffer;
                }

                if ((max > min)) {
                    i++;
                } else {
                    i--;
                }
            }
        }

        return array;
    }
}

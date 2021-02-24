package homework14;

import java.util.Arrays;

public class Main {
    public static Integer[] sliceAfterFour(Integer[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Array is empty");
        } else if (!Arrays.asList(array).contains(4)) {
            throw new RuntimeException("Array has no 4 value");
        }

        Integer[] result = null;
        int resultIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 4) {
                if (result == null) {
                    result = new Integer[array.length - i];
                }
                result[resultIndex++] = array[i];
            } else {
                result = null;
                resultIndex = 0;
            }
        }

        return result == null ? new Integer[0] : result;
    }

    public static boolean arrayContainsOnlyOneAndFour(int[] array) {
        if (array.length == 0) return false;

        boolean fours = false, ones = false, result = true;
        for (int element : array) {
            result = (element == 1 || element == 4) && result;
            if (element == 4) fours = true;
            else if (element == 1) ones = true;
        }

        return result && fours && ones;
    }
}

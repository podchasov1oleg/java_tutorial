import java.util.Arrays;
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ширину и высоту массива через пробел");
        int x, y;
        x = scanner.nextInt();
        y = scanner.nextInt();
        int[][] result = arrayFillSpiral(x, y);

        for (int[] array : result) {
            System.out.println(Arrays.toString(array));
        }
    }

    private static int[][] arrayFillSpiral(int x, int y) {
        int[][] result = new int[y][x];
        int value = 1, row = 0, col = 0;
        while (value <= x * y) {
            result[row][col] = value++;
            if (col < x - 1 && result[row][col + 1] == 0 && (row == 0 || result[row - 1][col] != 0)) {
                col++;
            } else if (row < y - 1 && result[row + 1][col] == 0) {
                row++;
            } else if (col > 0 && result[row][col - 1] == 0) {
                col--;
            } else if (row > 0 && result[row - 1][col] == 0) {
                row--;
            }
        }
        return result;
    }
}

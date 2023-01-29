package practice.baekjoon.stepbystep.twodimensionalarray;

import java.util.Arrays;

public class BJ2738 {
    int row;
    int column;
    private int[][] first;
    private int[][] second;

    public BJ2738(String input) {
        String[] strings = input.split("\n");
        String[] sizeString = strings[0].split(" ");
        row = Integer.parseInt(sizeString[0]);
        column = Integer.parseInt(sizeString[1]);
        first = new int[row][column];
        second = new int[row][column];

        for (int i = 0; i < row; i++) {
            String[] x = strings[i + 1].split(" ");
            for (int j = 0; j < column; j++) {
                first[i][j] = Integer.parseInt(x[j]);
            }
        }

        for (int i = row + 1; i < 2 * row + 1; i++) {

        }
    }

    public String answer(int[][] array) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(array).flatMapToInt(Arrays::stream);
        return null;
    }

    private int[][] add2DArrays() {
        int[][] result = new int[first.length][first[0].length];
        for (int i = 0; i < first.length; i++) {
            result[i] = add1DArrays(first[i], second[i]);
        }
        return result;
    }

    /**
     * Both argument must have same length.
     * @param firstArray
     * @param secondArray
     * @return
     */
    private int[] add1DArrays(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            result[i] = firstArray[i] + secondArray[i];
        }
        return result;
    }

}

package org.alan.algorithm.practice.programmers.integertriangle;

import java.util.Arrays;

public class IntegerTriangle3 {
    private int[][] triangle;
    private int[][] sumTriangle;

    public int solution(int[][] triangle) {
        this.triangle = triangle;
        sumTriangle = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            sumTriangle[i] = new int[i + 1];
        }

        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < triangle.length; i++) {
            leftSum += triangle[i][0];
            sumTriangle[i][0] = leftSum;
            rightSum += triangle[i][i];
            sumTriangle[i][i] = rightSum;
        }
        run(2, 1);

        return Arrays.stream(sumTriangle[sumTriangle.length - 1]).max().getAsInt();
    }

    private void run(int i, int j) {
        int length = sumTriangle.length;
        int previousLeft = sumTriangle[i - 1][j - 1];
        int previousRight = sumTriangle[i - 1][j];
        int left = triangle[i - 1][j - 1];
        int right = triangle[i - 1][j];

        if (i >= length || j >= length || previousLeft < left || previousRight < right) {
            return;
        }


        sumTriangle[i][j] = triangle[i][j] + Math.max(previousLeft, previousRight);

        run(i + 1, j);
        run(i + 1, j + 1);
        }

}

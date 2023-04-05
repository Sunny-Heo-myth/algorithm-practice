package org.alan.algorithm.practice.programmers.integertriangle;

import java.util.Arrays;

public class IntegerTriangle2 {
    private int[][] triangle;
    private int[][] sumTriangle;

    public int solution(int[][] triangle) {
        this.triangle = triangle;
        setSumTriangle();
        fillEdge();
        fillRest();
        return Arrays.stream(sumTriangle[sumTriangle.length - 1]).max().orElse(-1);
    }

    private void setSumTriangle() {
        sumTriangle = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            sumTriangle[i] = new int[triangle[i].length];
        }
    }

    private void fillEdge() {
        sumTriangle[0][0] = triangle[0][0];
        for (int i = 1; i < sumTriangle.length; i++) {
            sumTriangle[i][0] = triangle[i][0] + sumTriangle[i - 1][0];
            sumTriangle[i][sumTriangle[i].length - 1] = triangle[i][triangle[i].length - 1] + sumTriangle[i - 1][sumTriangle[i - 1].length - 1];
        }
    }

    private void fillRest() {
        for (int i = 2; i < sumTriangle.length; i++) {
            for (int j = 1; j < sumTriangle[i].length - 1; j++) {
                sumTriangle[i][j] = Math.max(sumTriangle[i - 1][j - 1], sumTriangle[i - 1][j]) + triangle[i][j];
            }
        }
    }
}

package org.alan.algorithm.practice.programmers.integertriangle;

import java.util.Arrays;

public class IntegerTriangle {
    private int[][] triangle;
    private Integer[][] triangleSum;

    public int solution(int[][] triangle) {
        this.triangle = triangle;
        setTriangleSum(triangle);
        fillTriangleSum(0, 0, 0);
        return Arrays.stream(triangleSum[triangleSum.length - 1]).reduce(Integer::max).orElse(-1);
    }

    private void setTriangleSum(int[][] triangle) {
        triangleSum = new Integer[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            triangleSum[i] = new Integer[triangle[i].length];
        }
    }

    private void fillTriangleSum(int row, int column, int previousNode) {
        if (row >= triangle.length) {
            return;
        }

        int candidateSum = previousNode + triangle[row][column];
        Integer nodeSum = triangleSum[row][column];

        if (nodeSum == null) {
            triangleSum[row][column] = candidateSum;
        } else {
            if (candidateSum > nodeSum) {
                triangleSum[row][column] = candidateSum;
            }
        }

        fillTriangleSum(row + 1, column, triangleSum[row][column]);
        fillTriangleSum(row + 1, column + 1, triangleSum[row][column]);
    }

}

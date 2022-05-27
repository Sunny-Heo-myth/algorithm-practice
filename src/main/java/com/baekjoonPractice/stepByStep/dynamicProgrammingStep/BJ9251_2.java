package com.baekjoonPractice.stepByStep.dynamicProgrammingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9251_2 {
    static char[] chars1;
    static char[] chars2;
    static Integer[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        chars1 = bf.readLine().toCharArray();
        chars2 = bf.readLine().toCharArray();
        matrix = new Integer[chars1.length][chars2.length];

        System.out.println(LCS(chars1.length - 1, chars2.length - 1));
    }

    static int LCS(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        if (matrix[x][y] == null) {
            matrix[x][y] = 0;

            if (chars1[x] == chars2[y]) {
                matrix[x][y] = LCS(x - 1, y - 1) + 1;
            }
            else {
                matrix[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }
        return matrix[x][y];
    }
}

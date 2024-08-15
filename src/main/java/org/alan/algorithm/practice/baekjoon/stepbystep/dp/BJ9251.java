package org.alan.algorithm.practice.baekjoon.stepbystep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9251 {
    static char[] str1;
    static char[] str2;
    static Integer[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        str1 = bf.readLine().toCharArray();
        str2 = bf.readLine().toCharArray();
        matrix = new Integer[str1.length][str2.length];

        System.out.println(LCS(str1.length - 1, str2.length - 1));
    }

    static int LCS(int x, int y) {
        if (x == -1 || y == -1) {
            return 0;
        }

        if (matrix[x][y] == null) {
            matrix[x][y] = 0;

            if (str1[x] == str2[y]) {
                matrix[x][y] = LCS(x - 1, y - 1) + 1;
            }
            else {
                matrix[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }
        return matrix[x][y];
    }

}

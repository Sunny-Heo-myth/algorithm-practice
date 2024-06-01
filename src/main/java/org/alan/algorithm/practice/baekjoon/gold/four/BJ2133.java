package org.alan.algorithm.practice.baekjoon.gold.four;

public class BJ2133 {
    public String solve(String input) {
        int N = Integer.parseInt(input);
        int[] tile = new int[N + 1];

        tile[0] = 1;
        for (int i = 2; i <= N; i += 2) {
            tile[i] = tile[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) tile[i] += tile[j] * 2;
        }
        return String.valueOf(tile[N]);
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.math;

import java.util.regex.Pattern;

public class BJ6064_2 {
    private final int M, N, X, Y;
    public BJ6064_2(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
        M = arr[0]; N = arr[1]; X = arr[2]; Y = arr[3];
    }

    public String solve() {
        int GCD = euclidean(Math.max(M, N), Math.min(M, N));
        if ((X - Y) % GCD != 0) return "-1";

        long i = 0, j = 0;
        while (i <= M || j <= N) {
            long x = M * i + X, y = N * j + Y;
            if (x > y) j++;
            else if (x < y) i++;
            else return String.valueOf(x);
        }
        return "-1";
    }

    private int euclidean(int big, int small) {
        while (small != 0) {
            int modular = big % small;
            big = small;
            small = modular;
        }
        return big;
    }
}

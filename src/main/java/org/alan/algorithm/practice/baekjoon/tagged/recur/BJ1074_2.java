package org.alan.algorithm.practice.baekjoon.tagged.recur;

import java.util.regex.Pattern;

public class BJ1074_2 {
    private final int N, x, y;

    public BJ1074_2(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input)
                .mapToInt(Integer::parseInt).toArray();
        N = arr[0]; x = arr[1]; y = arr[2];
    }

    public String solve() {
        return String.valueOf(recur(N, x, y));
    }

    private int recur(int n, int x, int y) {
        if (n == 0) return 0;
        int pow = (int) Math.pow(2, n - 1);

        return recur(n - 1, x % pow, y % pow)
                + pow * pow * (2 * (x >= pow ? 1 : 0) + (y >= pow ? 1 : 0));
    }

}

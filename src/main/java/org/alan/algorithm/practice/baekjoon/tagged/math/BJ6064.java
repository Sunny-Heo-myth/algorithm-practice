package org.alan.algorithm.practice.baekjoon.tagged.math;

import java.util.regex.Pattern;

public class BJ6064 {
    private final int M, N, x, y;

    public BJ6064(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input)
                .mapToInt(Integer::parseInt).toArray();
        M = arr[0]; N = arr[1]; x = arr[2]; y = arr[3];
    }

    public String solve() {
        int GCD = euclidean(Math.max(M, N), Math.min(M, N));
        if ((x - y) % GCD != 0) return "-1";

        int m = M / GCD, n = N / GCD, k = 0, l = 0, diff = (x - y) / GCD;
        while (true) {
            int calc = n * l - m * k;
            if (diff == calc) break;

            if (diff > calc) l++;
            else k++;
        }
        return String.valueOf(x + m * GCD * k);
    }

    private int euclidean(int big, int small) {
        if (small == 0) return big;
        return euclidean(small, big % small);
    }

}

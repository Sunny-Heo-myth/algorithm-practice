package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ11066 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int k = Integer.parseInt(s[0]);
        int[] arr = Pattern.compile(" ").splitAsStream("0 " + s[1]).mapToInt(Integer::parseInt).toArray();
        int[] sum = new int[k + 1];
        for (int i = 1; i <= k; i++) sum[i] = sum[i - 1] + arr[i];

        int[][] memo = new int[k + 1][k + 1];
        for (int n = 1; n <= k; n++) for (int i = 1; i + n <= k; i++) {
            int to = i + n;
            int from = i;
            memo[i][to] = IntStream.range(i, to)
                    .map(div -> memo[from][div] + memo[div + 1][to] + sum[to] - sum[from - 1])
                    .min().orElse(-1);
        }
        return String.valueOf(memo[1][k]);
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ11052 {
    private final int[] price, memo;

    public BJ11052(String input) {
        price = Pattern.compile(" ").splitAsStream("0 " + input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        memo = new int[price.length];
    }

    public String solve() {
        for (int i = 1; i < price.length; i++) {
            int ii = i;
            memo[ii] = IntStream.rangeClosed(0, ii - 1)
                    .map(j -> memo[j] + price[ii - j])
                    .max().orElse(0);
        }
        return String.valueOf(memo[memo.length - 1]);
    }
}

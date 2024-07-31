package org.alan.algorithm.practice.baekjoon.tagged.string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BJ1701 {
    public String solve(String input) {
        return String.valueOf(IntStream.range(0, input.length())
                .map(i -> getPreSufMax(input.substring(i))).max().orElse(0));
    }

    private int getPreSufMax(String pattern) {
        int l = 0, n = pattern.length();
        int[] pi = new int[n];

        for (int r = 1; r < n; r++) {
            while (l > 0 && pattern.charAt(l) != pattern.charAt(r)) l = pi[l - 1];
            if (pattern.charAt(l) == pattern.charAt(r)) pi[r] = ++l;
        }

        return Arrays.stream(pi).max().orElse(0);
    }

}

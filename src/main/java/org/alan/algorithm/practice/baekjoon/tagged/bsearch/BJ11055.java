package org.alan.algorithm.practice.baekjoon.tagged.bsearch;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ11055 {

    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream("0 " + input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        int l = arr.length;
        int[] memo = new int[l]; memo[1] = arr[1];

        for (int i = 1; i < l; i++) {
            memo[i] = arr[i];
            for (int j = 1; j < i; j++) if (arr[j] < arr[i]) memo[i] = Math.max(memo[i], memo[j] + arr[i]);
        }

        return String.valueOf(Arrays.stream(memo).max().orElse(-1));
    }

}

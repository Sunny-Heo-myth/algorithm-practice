package org.alan.algorithm.practice.baekjoon.silver.two;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ11053 {
    public String solve(String input) {
        int[] arr = input.lines().skip(1).flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt)).toArray();
        int[] memo = new int[arr.length]; Arrays.fill(memo, 1);

        for (int i = 0; i < arr.length; i++) for (int j = 0; j < i; j++)
            if (arr[j] < arr[i]) memo[i] = Math.max(memo[i], memo[j] + 1);
        return String.valueOf(Arrays.stream(memo).max().orElse(-1));
    }
}

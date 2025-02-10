package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ2629 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int[] weights = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();
        int total = Arrays.stream(weights).sum();
        boolean[] memo = new boolean[total + 1];

        memo[0] = true;
        for (int w : weights) {
            boolean[] tempMemo = memo.clone();
            for (int d = 0; d <= total; d++) if (memo[d]) {
                tempMemo[Math.abs(d - w)] = true;
                int sum = d + w;
                if (sum <= total) tempMemo[sum] = true;
            }
            memo = tempMemo;
        }

        boolean[] finalMemo = memo;
        return Pattern.compile(" ").splitAsStream(lines[3]).map(s -> {
            int marble = Integer.parseInt(s);
            return marble > total || !finalMemo[marble] ? "N" : "Y";
        }).collect(Collectors.joining(" "));
    }
}

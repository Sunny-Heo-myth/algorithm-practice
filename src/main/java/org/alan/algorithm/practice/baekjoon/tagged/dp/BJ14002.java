package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ14002 {
    private final int[] arr, memo;

    public BJ14002(String input) {
        arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        memo = new int[arr.length];
        Arrays.fill(memo, 1);
    }

    public String solve() {
        for (int i = 0; i < arr.length; i++) for (int j = 0; j < i; j++)
            if (arr[j] < arr[i]) memo[i] = Math.max(memo[i], memo[j] + 1);
        int max = Arrays.stream(memo).max().orElse(1);

        List<Integer> lis = new ArrayList<>();
        int n = max;
        for (int i = arr.length - 1; i >= 0; i--) if (memo[i] == n) {
            lis.add(arr[i]);
            n--;
        }
        Collections.reverse(lis);
        return max + "\n" + lis.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

}

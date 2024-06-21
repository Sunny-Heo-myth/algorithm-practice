package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ14002 {
    public String solve(String input) {
        int[] arr = input.lines().skip(1).flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream("0 " + s).mapToInt(Integer::parseInt)).toArray();
        int[] memo = new int[arr.length];

        int count = 0;
        for (int i = 1; i < arr.length; i++) for (int j = 0; j < i; j++) if (arr[i] > arr[j]) {
            memo[i] = Math.max(memo[i], memo[j] + 1);
            count = Math.max(count, memo[i]);
        }

        return getString(count, memo, arr);
    }

    public String solve2(String input) {
        int[] arr = input.lines().skip(1).flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream("0 " + s).mapToInt(Integer::parseInt)).toArray();
        int[] memo = new int[arr.length];

        int count = IntStream.range(1, arr.length).map(i -> IntStream.range(0, i)
                        .filter(j -> arr[i] > arr[j])
                        .peek(j -> memo[i] = Math.max(memo[i], memo[j] + 1))
                        .map(j -> memo[i])
                        .max().orElse(-1))
                .max().orElse(-1);

        return getString(count, memo, arr);
    }

    private String getString(int count, int[] memo, int[] arr) {
        int temp = count;
        Stack<Integer> stack = new Stack<>();
        for (int i = memo.length - 1; i >= 1; i--) if (memo[i] == temp) {
            temp--;
            stack.push(arr[i]);
        }
        List<String> ss = stack.stream().map(String::valueOf).collect(Collectors.toList());
        Collections.reverse(ss);
        return count + "\n" + String.join(" ", ss);
    }
}

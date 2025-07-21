package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ17298 {

    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();

        int[] rbn = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) stack.pop();
            rbn[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }

        return Arrays.stream(rbn).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}

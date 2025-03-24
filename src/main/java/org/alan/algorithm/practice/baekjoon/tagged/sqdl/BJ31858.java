package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import java.util.Arrays;
import java.util.Stack;

public class BJ31858 {
    private final int[] arr;

    public BJ31858(String input) {
        arr = Arrays.stream(input.split("\n")[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public String solve() {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                count++;
                stack.pop();
            }

            if (!stack.isEmpty()) count++;
            stack.push(i);
        }
        return String.valueOf(count);
    }

}

package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ6198 {

    public String solve(String input) {
        int[] arr = Pattern.compile("\n").splitAsStream(input + "\n" + 1_000_000_000)
                .skip(1).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();

        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) answer += i - stack.pop() - 1;
            stack.push(i);
        }
        return String.valueOf(answer);
    }
}

package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import java.util.Stack;

public class BJ10773 {
    public String solve(String input) {
        // parse
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        int[] ints = new int[n];
        for (int i = 1; i < n + 1; i++) {
            ints[i - 1] = Integer.parseInt(s[i]);
        }

        // declare int stack
        Stack<Integer> integerStack = new Stack<>();

        for (int i : ints) {
            if (i == 0) {
                integerStack.pop();
            } else {
                integerStack.push(i);
            }
        }

        // sum the stack and return
        return String.valueOf(integerStack.stream().reduce(0, Integer::sum));   // todo: reduce
    }
}

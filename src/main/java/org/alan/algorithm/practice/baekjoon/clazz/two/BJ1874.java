package org.alan.algorithm.practice.baekjoon.clazz.two;

import java.util.Objects;
import java.util.Stack;

public class BJ1874 {

    public String solve(String input) {

        int[] arr = input.lines().skip(1).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> print = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) print.push(arr[i]);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int size = print.size();
        for (int i = 1; i <= size; i++) {
            stack.push(i);
            sb.append("+").append("\n");
            while (!stack.isEmpty() && !print.isEmpty() && Objects.equals(stack.peek(), print.peek())) {
                stack.pop();
                print.pop();
                sb.append("-").append("\n");
            }
        }

        return print.isEmpty() ? sb.toString() : "NO";
    }
}

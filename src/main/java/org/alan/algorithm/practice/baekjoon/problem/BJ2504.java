package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Stack;

public class BJ2504 {

    public String solve(String input) {
        char[] arr = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0, multiple = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push('(');
                multiple *= 2;
            } else if (arr[i] == '[') {
                stack.push('[');
                multiple *= 3;
            } else if (arr[i] == ')') {
                if (stack.isEmpty() || stack.peek() == '[') return "0";
                if (arr[i - 1] == '(') result += multiple;
                stack.pop();
                multiple /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() == '(') return "0";
                if (arr[i - 1] == '[') result += multiple;
                stack.pop();
                multiple /= 3;
            }
        }
        return String.valueOf(stack.isEmpty() ? result : 0);
    }

}

package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Stack;

public class BJ2504 {

    public String solve(String input) {
        int answer = 0;
        int multiple = 1;
        boolean flag = true;

        Stack<Character> stack = new Stack<>();
        loop: for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '(':
                    stack.push('(');
                    multiple *= 2;
                    break;
                case '[':
                    stack.push('[');
                    multiple *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break loop;
                    }
                    if (input.charAt(i - 1) == '(') {
                        answer += multiple;
                    }
                    stack.pop();
                    multiple /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break loop;
                    }
                    if (input.charAt(i - 1) == '[') {
                        answer += multiple;
                    }
                    stack.pop();
                    multiple /= 3;
                    break;
            }
        }

        return !flag || !stack.isEmpty() ? "0" : String.valueOf(answer);
    }

    public String solve2(String input) {
        char LEFT_P = '(', RIGHT_P = ')', LEFT_S = '[', RIGHT_S = ']';

        int answer = 0;
        int multiple = 1;
        boolean flag = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == LEFT_P) {
                stack.push(c);
                multiple *= 2;
            } else if (c == LEFT_S) {
                stack.push(c);
                multiple *= 3;
            } else if (c == RIGHT_P) {
                if (stack.isEmpty() || stack.peek() != LEFT_P) {
                    flag = false;
                    break;
                }
                if (input.charAt(i - 1) == LEFT_P) {
                    answer += multiple;
                }
                stack.pop();
                multiple /= 2;
            } else if (c == RIGHT_S) {
                if (stack.isEmpty() || stack.peek() != LEFT_S) {
                    flag = false;
                    break;
                }
                if (input.charAt(i - 1) == LEFT_S) {
                    answer += multiple;
                }
                stack.pop();
                multiple /= 3;
            }

        }

        return !flag || !stack.isEmpty() ? "0" : String.valueOf(answer);
    }
}

package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Stack;

public class BJ15926 {
    public String solve(String input) {
        char[] arr = input.split("\n")[1].toCharArray();

        Stack<Ch> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Ch(arr[i], i));
            } else {
                if (stack.peek().ch == '(') {
                    if (arr[i] == ')') {
                        stack.pop();
                    } else {
                        stack.push(new Ch('(', i));
                    }
                } else {
                    stack.push(new Ch(arr[i], i));
                }
            }
        }

        if (stack.isEmpty()) {
            return String.valueOf(arr.length);
        } else {
            int max = 0;
            while (!stack.isEmpty()) {
                Ch now = stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, now.idx);
                } else {
                    max = Math.max(max, now.idx - stack.peek().idx);
                }
            }
            return String.valueOf(max);
        }
    }

    private static class Ch {
        private final char ch;
        private final int idx;

        public Ch(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    public String solve2(String input) {
        char[] arr = input.split("\n")[1].toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return String.valueOf(max);
    }

}

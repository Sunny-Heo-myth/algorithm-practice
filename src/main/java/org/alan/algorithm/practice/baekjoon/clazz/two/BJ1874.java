package org.alan.algorithm.practice.baekjoon.clazz.two;

import java.util.Stack;

public class BJ1874 {
    public String solve(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        String[] s = input.split("\n");

        int max = 0;
        for (int ss = 1; ss < s.length; ss++) {
            int i = Integer.parseInt(s[ss]);

            if (max < i) {
                for (int j = max + 1; j <= i; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
                max = i;

            } else {
                if (stack.peek() != i) return "NO";
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        return sb.toString();
    }
}

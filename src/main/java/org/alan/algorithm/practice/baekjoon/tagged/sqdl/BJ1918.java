package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import java.util.Stack;

// todo:
public class BJ1918 {

    public String solve(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char now : str.toCharArray())
            switch (now) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) sb.append(stack.pop());
                    stack.add(now);
                    break;

                case '(':
                    stack.add(now);
                    break;

                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());
                    stack.pop();
                    break;

                default:
                    sb.append(now);
            }

        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }

    private int priority(char operator){
        if (operator == '*' || operator == '/') return 2;
        else if (operator == '+' || operator == '-') return 1;
        else if (operator == '(' || operator == ')') return 0;
        else return -1;
    }

}

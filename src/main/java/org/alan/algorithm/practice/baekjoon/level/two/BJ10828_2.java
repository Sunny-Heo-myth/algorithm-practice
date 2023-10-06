package org.alan.algorithm.practice.baekjoon.level.two;

public class BJ10828_2 {
    private static final String TOP = "top";
    private static final String SIZE = "size";
    private static final String ISEMPTY = "empty";
    public static final String POP = "pop";

    private int[] stack;
    private int pointer = 0;

    public String solve(String input) {
        String[] s = input.split("\n");
        stack = new int[Integer.parseInt(s[0])];

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < s.length; i++) {
            String[] ss = s[i].split(" ");
            if (ss.length != 1) {
                push(Integer.parseInt(ss[1]));
            } else {
                answer.append(operate(s[i])).append("\n");
            }
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }

    private int operate(String operation) {
        switch (operation) {
            case TOP: return top();
            case POP: return pop();
            case ISEMPTY: return isEmpty();
            case SIZE: return size();
        }
        throw new IllegalArgumentException();
    }

    private void push(int n) {
        stack[pointer] = n;
        pointer++;
    }

    private int pop() {
        if (pointer == 0) {
            return -1;
        }

        int value = stack[pointer - 1];
        stack[pointer-- - 1] = 0;
        return value;
    }

    private int size() {
        return pointer;
    }

    private int isEmpty() {
        return pointer == 0 ? 1 : 0;
    }

    private int top() {
        if (pointer == 0) {
            return -1;
        }
        return stack[pointer - 1];
    }
}

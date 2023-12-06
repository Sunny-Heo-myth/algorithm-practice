package org.alan.algorithm.practice.baekjoon.clazz.two;

import java.util.LinkedList;

public class BJ10828 {
    public String solve(String input) {
        String[] s = input.split("\n");
        StringBuilder answer = new StringBuilder();
        BJ10828Stack stack = new BJ10828Stack();

        for (int i = 1; i < s.length; i++) {
            String[] ss = s[i].split(" ");
            if (ss.length != 1) {
                stack.push(Integer.parseInt(ss[1]));
            } else {
                answer.append(stack.operate(s[i])).append("\n");
            }
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }

    private class BJ10828Stack {
        private static final String TOP = "top";
        private static final String SIZE = "size";
        private static final String ISEMPTY = "empty";
        public static final String POP = "pop";

        private final LinkedList<Integer> linkedList = new LinkedList<>();

        private int operate(String operation) {
            switch (operation) {
                case TOP: return top();
                case POP: return pop();
                case ISEMPTY: return isEmpty();
                case SIZE: return size();
            }
            throw new IllegalArgumentException();
        }

        private int top() {
            return linkedList.peek() != null ? linkedList.peek() : -1;
        }

        private int pop() {
            return linkedList.peek() != null ? linkedList.pop() : -1;
        }

        private void push(int n) {
            linkedList.push(n);
        }

        private int isEmpty() {
            return linkedList.isEmpty() ? 1 : 0;
        }

        private int size() {
            return linkedList.size();
        }
    }

}

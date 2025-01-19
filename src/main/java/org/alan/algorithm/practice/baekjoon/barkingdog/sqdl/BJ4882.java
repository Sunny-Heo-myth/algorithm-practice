package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import java.util.Stack;

public class BJ4882 {
    private static final char LEFT = '(', RIGHT = ')', TRUE = 'T', FALSE = 'F';
    private static int questionNumber = 0;

    public String solve(String input) {
        int max = 0, count = 0;
        for (char ch : input.toCharArray()) {
            if (ch == LEFT) max = Math.max(max, ++count);
            else if (ch == RIGHT) --count;
        }

        boolean isCNF = max % 2 == 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == LEFT) {
                stack.push(ch);
                isCNF = !isCNF;

            } else if (ch == RIGHT) {
                boolean isTrue;
                if (isCNF) {
                    isTrue = true;
                    while (stack.peek() != LEFT) if (stack.pop() == FALSE) isTrue = false;
                } else {
                    isTrue = false;
                    while (stack.peek() != LEFT) if (stack.pop() == TRUE) isTrue = true;
                }

                stack.pop();
                stack.push(isTrue ? TRUE : FALSE);
                isCNF = !isCNF;

            } else {
                stack.push(ch);
            }
        }

        return ++questionNumber + ". " + (stack.pop() == TRUE ? "true" : "false");
    }
}

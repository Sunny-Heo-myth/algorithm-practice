package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import java.util.Stack;
import java.util.stream.Collectors;

public class BJ4970 {
    private static final char TRUE = '2', UNKNOWN = '1', FALSE = '0';
    private static final char[] ARR = {TRUE, FALSE, UNKNOWN};

    public String solve(String input) {
        int answer = 0;
        for (char p : ARR) for (char q : ARR) for (char r : ARR) {
            String copy = input.chars()
                    .map(ch -> switch (ch) {
                        case 'P' -> p;
                        case 'Q' -> q;
                        case 'R' -> r;
                        default -> ch;
                    })
                    .mapToObj(i -> String.valueOf((char) i))
                    .collect(Collectors.joining());

            Stack<Character> stack = new Stack<>();
            for (char ch : copy.toCharArray()) {
                if (ch != ')') {
                    stack.push(ch);
                } else {
                    char x = negate(stack), op = stack.pop(), y = negate(stack);
                    stack.pop();
                    stack.push(operate(x, y, op));
                }
            }
            if (negate(stack) == TRUE) answer++;
        }
        return String.valueOf(answer);
    }

    private char negate(Stack<Character> stack) {
        char x = stack.pop();
        int count = 0;
        while (!stack.isEmpty() && stack.peek() == '-') {
            stack.pop();
            count++;
        }
        return x == UNKNOWN ? UNKNOWN : count % 2 == 0 ? x : x == TRUE ? FALSE : TRUE;
    }

    private char operate(char o1, char o2, char op) {
        return switch (op) {
            case '*' -> {
                if (o1 == FALSE || o2 == FALSE) yield FALSE;
                if (o1 == TRUE && o2 == TRUE) yield TRUE;
                yield UNKNOWN;
            }
            case '+' -> {
                if (o1 == TRUE || o2 == TRUE) yield TRUE;
                if (o1 == FALSE && o2 == FALSE) yield FALSE;
                yield UNKNOWN;
            }
            default -> throw new IllegalArgumentException();
        };
    }

}

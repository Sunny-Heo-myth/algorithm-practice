package org.alan.algorithm.practice.baekjoon.tagged.stack;

import java.util.Stack;

public class BJ1662 {
    private final String formula;
    private final Stack<Integer> operand = new Stack<>(), multiple = new Stack<>();

    public BJ1662(String input) {
        formula = input;
    }

    public String solve() {
        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                operand.push(operand.pop() - 1);
                multiple.push(Integer.parseInt(String.valueOf(formula.charAt(i - 1))));
                operand.push(0);
            } else if (ch == ')') {
                operand.push(multiple.pop() * operand.pop() + operand.pop());
            } else {
                operand.push(operand.isEmpty() ? 1 : operand.pop() + 1);
            }
        }

        return String.valueOf(operand.stream().mapToInt(Integer::valueOf).sum());
    }
}

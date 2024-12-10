package org.alan.algorithm.practice.baekjoon.problem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ19591 {
    private final List<String> multi = List.of("*", "/");

    public String solve(String input) {
        Deque<Long> operands = Pattern.compile("[*+\\-/]").splitAsStream(input)
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> operators = Pattern.compile("\\d+").splitAsStream(input)
                .collect(Collectors.toCollection(ArrayDeque::new));
        operators.pollFirst();
        if (input.charAt(0) == '-') operands.offerFirst(-operands.pollFirst());

        String topOp, bottomOp;
        long top, topResult, bottom, bottomResult;
        while (!operators.isEmpty()) {

            topOp = operators.peekFirst();
            bottomOp = operators.peekLast();

            if (multi.contains(topOp) && !multi.contains(bottomOp)) {
                operators.pollFirst();
                operands.offerFirst(calculate(topOp, operands.pollFirst(), operands.pollFirst()));
            } else if (!multi.contains(topOp) && multi.contains(bottomOp)) {
                operators.pollLast();
                bottom = operands.pollLast();
                operands.offerLast(calculate(bottomOp, operands.pollLast(), bottom));
            } else {
                top = operands.pollFirst();
                topResult = calculate(topOp, top, operands.peekFirst());
                operands.offerFirst(top);

                bottom = operands.pollLast();
                bottomResult = calculate(bottomOp, operands.peekLast(), bottom);
                operands.offerLast(bottom);

                if (topResult >= bottomResult) {
                    operators.pollFirst();
                    operands.pollFirst();
                    operands.pollFirst();
                    operands.offerFirst(topResult);
                } else {
                    operators.pollLast();
                    operands.pollLast();
                    operands.pollLast();
                    operands.offerLast(bottomResult);
                }
            }
        }

        return String.valueOf(operands.poll());
    }

    private long calculate(String operator, long left, long right) {
        return switch (operator) {
            case "*" -> left * right;
            case "+" -> left + right;
            case "-" -> left - right;
            case "/" -> left / right;
            default -> throw new IllegalArgumentException();
        };
    }

}

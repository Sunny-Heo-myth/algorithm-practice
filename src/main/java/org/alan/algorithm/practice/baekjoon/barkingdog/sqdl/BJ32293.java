package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import java.util.Stack;
import java.util.stream.Collectors;

public class BJ32293 {
    private static final int A = 'A', B = 'B';

    public String solve(String input) {
        int[] chars = input.split("\n")[1].chars().toArray();
        Stack<Integer> stack = new Stack<>();

        // initiation: No characters are included for answer string, thus stack is empty.
        // after loop: 'ch' has been included to answer string stack represent calculated string in order.
        // termination: All characters are included for answer string, thus stack represents the result.
        for (int ch : chars) {
            stack.push(ch);

            // initiation:
            //  - Stack is calculated before including ch.
            //  - No transition found yet, count is 0.
            // after loop:
            //  - A transition has been found. Count incremented.
            //  - A single 'B' pushed to the stack since it can be used for next transition.
            // termination:
            //  - All possible transition has been calculated.
            //  - Count represent the number of transition found by including ch.
            int count = 0;
            while (stack.size() >= 3) {
                int first = stack.pop(), second = stack.pop(), third = stack.peek();
                if (first == B && second == B && third == A) {
                    stack.pop();
                    stack.push(B);
                    count++;
                } else {
                    stack.push(second);
                    stack.push(first);
                    break;
                }
            }

            for (int i = 0; i < count; i++) stack.push(A);
        }

        return stack.stream().map(i -> String.valueOf((char) i.intValue())).collect(Collectors.joining());
    }
}

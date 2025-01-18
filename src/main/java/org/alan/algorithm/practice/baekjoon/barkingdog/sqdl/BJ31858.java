package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ31858 {
    public String solve(String input) {
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();

        // initiation :
        //  - Stack is empty.
        // after loop :
        //  - Stack peek is n.
        //  - All count including case with second element as n has been considered.
        // termination :
        //  - All count considered starting from the first to the last element as the second element of a case.
        int count = 0;
        for (int n : arr) {
            // initiation :
            //  - n is the second element of a possible case.
            //  - Continuous stack pop will give numbers with ascending order.
            // after loop :
            //  - Counting with n and stack pop has been considered.
            // termination :
            //  - If stack is not empty, stack peek is bigger than n.
            //  - If stack is empty, all possible counting of the cases with second element as n has been considered.
            while (!stack.isEmpty() && stack.peek() < n) {
                stack.pop();
                count++;
            }
            if (!stack.isEmpty()) count++;
            stack.push(n);
        }
        return String.valueOf(count);
    }
}

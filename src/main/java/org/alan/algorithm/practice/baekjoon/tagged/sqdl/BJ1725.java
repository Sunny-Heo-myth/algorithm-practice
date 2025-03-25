package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import java.util.Stack;

public class BJ1725 {
    private final long[] arr;

//    public BJ1725(String input) {
//        arr = input.lines().skip(1).mapToLong(Long::parseLong).toArray();
//    }

//    public String solve() {
//        long max = 0;
//        Stack<Integer> stack = new Stack<>();
//
//        int i = 0;
//        while (i < arr.length) {
//            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) stack.push(i++);
//            else {
//                long area = arr[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1);
//                max = Math.max(max, area);
//            }
//        }
//
//        while (!stack.isEmpty()) {
//            long area = arr[stack.pop()] * (arr.length - (stack.isEmpty() ? 0 : stack.peek() + 1));
//            max = Math.max(max, area);
//        }
//        return String.valueOf(max);
//    }


    public BJ1725(String input) {
        String[] lines = input.split("\n");
        arr = new long[Integer.parseInt(lines[0]) + 2];
        for (int i = 1; i < arr.length - 1; i++) arr[i] = Long.parseLong(lines[i]);
    }

    public String solve2() {
        Stack<Integer> stack = new Stack<>();
        long max = 0;

        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty()) {
                if (arr[stack.peek()] <= arr[i]) break;
                max = Math.max(max, arr[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return String.valueOf(max);
    }

}

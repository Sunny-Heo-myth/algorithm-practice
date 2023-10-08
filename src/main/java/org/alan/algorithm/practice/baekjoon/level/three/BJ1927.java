package org.alan.algorithm.practice.baekjoon.level.three;

import java.util.PriorityQueue;

public class BJ1927 {
    private final PriorityQueue<Integer> integers = new PriorityQueue<>();

    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(s[i + 1]);
            if (number == 0) sb.append(pop()).append("\n");
            else integers.add(number);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private int pop() {
        return integers.isEmpty() ? 0 : integers.poll();
    }


}

package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.LinkedList;
import java.util.Queue;

public class BJ1697 {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int[] counts = new int[100001];

    public String solve(String input) {
        String[] s = input.split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        // I always prefer endIndex is not covered.

        int answer = move(x, y);
        return String.valueOf(answer);
    }

    private int move(int from, int to) {
        queue.add(from);
        while (!queue.isEmpty()) {
            int next = queue.poll();

            if (next == to) return counts[next];

            int nextCount = counts[next] + 1;
            conditionedOffer(next * 2, nextCount);
            conditionedOffer(next + 1, nextCount);
            conditionedOffer(next - 1, nextCount);
        }
        return -1;
    }

    private void conditionedOffer(int index, int step) {
        if (index >= 0 && index < 100001 && counts[index] == 0){
            counts[index] = step;
            queue.offer(index);
        }
    }

}

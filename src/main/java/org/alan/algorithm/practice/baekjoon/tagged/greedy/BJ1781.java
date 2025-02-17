package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class BJ1781 {
    public String solve(String input) {
        int[][] tasks = input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .sorted(Comparator.comparingInt(task -> task[0]))
                .toArray(int[][]::new);

        PriorityQueue<Integer> ramens = new PriorityQueue<>();

        long total = 0;
        for (int[] task : tasks) {
            int deadline = task[0], ramen = task[1];
            ramens.offer(ramen);
            total += ramen;
            if (ramens.size() > deadline) total -= ramens.poll();
        }
        return String.valueOf(total);
    }
}

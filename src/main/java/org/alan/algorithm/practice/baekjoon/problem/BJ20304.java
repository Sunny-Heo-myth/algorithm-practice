package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ20304 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int n = Integer.parseInt(lines[0]);

        int[] distances = IntStream.generate(() -> -1).limit(n + 1).toArray();
        Queue<Integer> queue = new LinkedList<>();
        Pattern.compile(" ").splitAsStream(lines[2]).mapToInt(Integer::parseInt).forEach(i -> {
            distances[i] = 0;
            queue.offer(i);
        });

        int bits = (int) (Math.floor(Math.log(n) / Math.log(2)) + 1);
        int max = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < bits; i++) {
                int nx = x ^ (1 << i);  // XOR with 1 flips the radix.
                if (nx > n || distances[nx] != -1) continue;

                queue.offer(nx);
                distances[nx] = distances[x] + 1;
                max = Math.max(max, distances[nx]);
            }
        }
        return String.valueOf(max);
    }
}

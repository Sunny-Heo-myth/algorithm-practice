package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ11000 {
    public String solve(String input) {
        int[][] classes = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .sorted((ints1, ints2) -> ints1[0] == ints2[0] ? ints1[1] - ints2[1] : ints1[0] - ints2[0])
                .toArray(int[][]::new);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(classes[0][1]);

        IntStream.range(1, classes.length).forEach(i -> {
            if (pq.peek() <= classes[i][0]) pq.poll();
            pq.offer(classes[i][1]);
        });

        return String.valueOf(pq.size());
    }
}

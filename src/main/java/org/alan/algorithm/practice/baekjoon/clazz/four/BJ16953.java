package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ16953 {
    public String solve(String input) {
        long[] longs = Arrays.stream(input.split(" ")).mapToLong(Long::parseLong).toArray();
        long from = longs[0]; long to = longs[1];

        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(ints2 -> ints2[0]));
        queue.offer(new long[]{from, 1});
        while (!queue.isEmpty()) {
            long[] now = queue.poll();

            if (now[0] >= to) {
                if (now[0] == to) return String.valueOf(now[1]);
                return "-1";
            }

            queue.offer(new long[]{now[0] * 2, now[1] + 1});
            queue.offer(new long[]{Long.parseLong(now[0] + "1"), now[1] + 1});
        }
        return "-1";
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BJ8980 {
    private final int[] available;
    private final List<int[]> deliveries;

    public BJ8980(String input) {
        int[][] lines = input.lines().map(s ->
                Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        available = new int[lines[0][0] + 1];
        Arrays.fill(available, lines[0][1]);
        deliveries = Arrays.stream(lines).skip(2)
                .sorted((d1, d2) -> d1[1] == d2[1] ? d2[0] - d1[0] : d1[1] - d2[1])
                .collect(Collectors.toList());
    }

    public String solve() {
        int n = 0;
        for (int[] d : deliveries) {
            int from = d[0], to = d[1], box = d[2];
            int loadable = Arrays.stream(available).skip(from).limit(to - from).min().orElse(0);
            int loaded = Math.min(box, loadable);
            if (loaded == 0) continue;
            for (int i = from; i < to; i++) available[i] -= loaded;
            n += loaded;
        }
        return String.valueOf(n);
    }
}

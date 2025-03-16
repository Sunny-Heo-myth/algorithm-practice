package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import java.util.*;
import java.util.stream.Collectors;

public class BJ1939 {
    private final List<List<int[]>> graph = new ArrayList<>();
    private final int N, start, end;

    public BJ1939(String input) {
        int[][] arr = input.lines().map(s -> Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        N = arr[0][0];
        int M = arr[0][1];
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int b = 1; b <= M; b++) {
            graph.get(arr[b][0]).add(new int[]{arr[b][1], arr[b][2]});
            graph.get(arr[b][1]).add(new int[]{arr[b][0], arr[b][2]});
        }
        for (int i = 1; i <= N; i++) {
            graph.add(i, graph.remove(i).stream()
                    .collect(Collectors.toMap(edge -> edge[0], edge -> edge[1], Math::max))
                    .entrySet().stream()
                    .map(e -> new int[]{e.getKey(), e.getValue()})
                    .collect(Collectors.toList()));
        }
        start = arr[M + 1][0];
        end = arr[M + 1][1];
    }

    public String solve() {
        Queue<Integer> queue = new LinkedList<>();
        int[] maxes = new int[N + 1];

        maxes[start] = Integer.MAX_VALUE;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int from = queue.poll();
            if (from == end) continue;

            for (int[] n : graph.get(from)) {
                int to = n[0], cost = n[1], until = Math.min(maxes[from], cost);
                if (maxes[to] < until) {
                    maxes[to] = until;
                    queue.offer(to);
                }
            }
        }
        return String.valueOf(maxes[end]);
    }
}

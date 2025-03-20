package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import java.util.*;
import java.util.stream.Collectors;

public class BJ1854 {
    private final int[][] graph;
    private final int k;

    public BJ1854(String input) {
        int[][] arr = input.lines().map(s -> Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        graph = new int[arr[0][0] + 1][arr[0][0] + 1];
        for (int i = 1; i <= arr[0][1]; i++) graph[arr[i][0]][arr[i][1]] = arr[i][2];
        k = arr[0][2];
    }

    public String solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node[1]));
        List<PriorityQueue<Integer>> shortestPaths = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) shortestPaths.add(new PriorityQueue<>(Comparator.reverseOrder()));

        pq.offer(new int[]{1, 0});
        shortestPaths.get(1).offer(0);
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int from = poll[0], spent = poll[1];

            for (int to = 1; to < graph.length; to++) if (graph[from][to] != 0) {
                int spend = spent + graph[from][to];
                PriorityQueue<Integer> shortestPath = shortestPaths.get(to);
                if (shortestPath.size() < k) {
                    pq.offer(new int[]{to, spend});
                    shortestPath.offer(spend);
                } else if (shortestPath.peek() > spend) {
                    shortestPath.poll();
                    pq.offer(new int[]{to, spend});
                    shortestPath.offer(spend);
                }
            }
        }

        return shortestPaths.stream().skip(1)
                .map(node -> node.size() != k ? "-1" : String.valueOf(node.peek()))
                .collect(Collectors.joining("\n"));
    }

}

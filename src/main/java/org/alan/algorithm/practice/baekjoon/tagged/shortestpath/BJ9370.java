package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import java.util.*;
import java.util.stream.Collectors;

public class BJ9370 {
    private final int[] sTo, gTo, hTo;
    private final int[][] graph;
    private final int s, g, h;
    private final List<Integer> destinations = new ArrayList<>();

    public BJ9370(String input) {
        int[][] arr = input.lines().map(s -> Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int n = arr[0][0], m = arr[0][1], t = arr[0][2]; s = arr[1][0]; g = arr[1][1]; h = arr[1][2];
        sTo = new int[n + 1]; gTo = new int[n + 1]; hTo = new int[n + 1];
        graph = new int[n + 1][n + 1];
        for (int i = 2; i < m + 2; i++) {
            graph[arr[i][0]][arr[i][1]] = arr[i][2];
            graph[arr[i][1]][arr[i][0]] = arr[i][2];
        }
        for (int i = m + 2; i < m + 2 + t; i++) destinations.add(arr[i][0]);
        Collections.sort(destinations);
    }

    public String solve() {
        getShortestPath(s, sTo);
        getShortestPath(g, gTo);
        getShortestPath(h, hTo);

        return destinations.stream()
                .filter(d ->
                        (sTo[g] + graph[g][h] + hTo[d] == sTo[d]) ||
                        (sTo[h] + graph[h][g] + gTo[d] == sTo[d]))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private void getShortestPath(int s, int[] shortest) {
        Queue<Integer> pq = new LinkedList<>();
        Arrays.fill(shortest, Integer.MAX_VALUE);

        shortest[s] = 0;
        pq.offer(s);
        while (!pq.isEmpty()) {
            int from = pq.poll();

            for (int to = 1; to < graph[from].length; to++) if (graph[from][to] != 0) {
                int until = shortest[from] + graph[from][to];
                if (shortest[to] > until) {
                    shortest[to] = until;
                    pq.offer(to);
                }
            }
        }
    }

}

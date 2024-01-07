package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.*;
import java.util.stream.IntStream;

public class BJ1504 {
    private int[] shortest;
    private boolean[] visited;
    private final List<List<int[]>> adjacency = new ArrayList<>(); // stateless
    private static final int NO_EDGE = 200000000;

    public String solve(String input) {
        String[] s = input.split("\n");
        StringTokenizer st = new StringTokenizer(s[0]);
        int numberOfVertices = getInt(st);
        int numberOfEdges = getInt(st);

        IntStream.range(0, numberOfVertices + 1).forEach(i -> adjacency.add(new ArrayList<>()));
        shortest = new int[numberOfVertices + 1];
        visited = new boolean[numberOfVertices + 1];

        for (int i = 0; i < numberOfEdges; i++) {
            st = new StringTokenizer(s[i + 1]);
            int from = getInt(st);
            int to = getInt(st);
            int cost = getInt(st);
            adjacency.get(from).add(new int[]{to, cost});
            adjacency.get(to).add(new int[]{from, cost});
        }

        st = new StringTokenizer(s[numberOfEdges + 1]);
        int stopOver1 = getInt(st);
        int stopOver2 = getInt(st);

        int oneTwo = dijkstra(stopOver1, stopOver2);
        int route1 = oneTwo + dijkstra(1, stopOver1) + dijkstra(stopOver2, numberOfVertices);
        int route2 = oneTwo + dijkstra(1, stopOver2) + dijkstra(stopOver1, numberOfVertices);
        return String.valueOf(route1 >= NO_EDGE && route2 >= NO_EDGE ? -1 : Math.min(route1, route2));
    }

    private int dijkstra(int start, int end) {
        Arrays.fill(shortest, NO_EDGE);
        Arrays.fill(visited, false);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(ints -> ints[1]));
        queue.offer(new int[]{start, 0});
        shortest[start] = 0;
        visited[start] = true;

        while (!queue.isEmpty()) {
            int nowTo = queue.poll()[0];
            visited[nowTo] = true;
            adjacency.get(nowTo).stream()
                    .filter(next -> !visited[next[0]] && shortest[next[0]] > shortest[nowTo] + next[1])
                    .forEach(next -> {
                        shortest[next[0]] = shortest[nowTo] + next[1];
                        queue.add(new int[]{next[0], shortest[next[0]]});
                    });
        }
        return shortest[end];
    }

    private int getInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

}
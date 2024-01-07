package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1753 {
    private boolean[] visited;
    private int[] shortest;
    private Map<Integer, List<int[]>> adjacency;  // stateless

    public String solve(String input) {
        int start = parse(input);
        dijkstra(start);
        return IntStream.range(1, shortest.length)
                .mapToObj(i -> shortest[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(shortest[i]))
                .collect(Collectors.joining("\n"));
    }

    private void dijkstra(int start) {
        visited = new boolean[adjacency.size() + 1];
        shortest = new int[adjacency.size() + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(ints -> ints[1]));

        shortest[start] = 0;
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int now = queue.poll()[0];
            visited[now] = true;
            adjacency.get(now).stream()
                    .filter(next -> !visited[next[0]] && shortest[next[0]] > shortest[now] + next[1])
                    .forEach(next -> {
                        shortest[next[0]] = shortest[now] + next[1];
                        queue.offer(new int[]{next[0], shortest[next[0]]});
                    });
        }
    }

    private int parse(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");

        adjacency = new HashMap<>();
        for (int i = 0; i < Integer.parseInt(firstLine[0]); i++) adjacency.put(i + 1, new ArrayList<>());
        for (int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
            String[] ss = s[i + 2].split(" ");
            adjacency.get(Integer.parseInt(ss[0])).add(new int[]{Integer.parseInt(ss[1]), Integer.parseInt(ss[2])});
        }
        return Integer.parseInt(s[1]);
    }

}

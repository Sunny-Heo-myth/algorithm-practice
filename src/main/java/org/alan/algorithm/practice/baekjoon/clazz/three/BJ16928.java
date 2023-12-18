package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ16928 {

    public String solve(String input) {
        int[] shortest = new int[101];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        List<List<Edge>> edges = new ArrayList<>();
        edges.add(new ArrayList<>());
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(new Edge(1, 0));

        IntStream.rangeClosed(1, 100).forEach(i -> edges.add(IntStream.rangeClosed(i + 1, i + 6)
                .takeWhile(j -> j <= 100).mapToObj(j -> new Edge(j, 1)).collect(Collectors.toList())));

        input.lines().skip(1).map(s -> s.split(" "))
                .forEach(s -> edges.get(Integer.parseInt(s[0])).add(new Edge(Integer.parseInt(s[1]), 0)));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            for (Edge next : edges.get(now.terminal)) {
                if (shortest[next.terminal] != Integer.MAX_VALUE) {
                    if (shortest[next.terminal] > now.cost + 1) {
                        shortest[next.terminal] = now.cost + 1;
                        queue.offer(new Edge(next.terminal, shortest[next.terminal]));
                    }
                } else {
                    shortest[next.terminal] = now.cost + 1;
                    queue.offer(new Edge(next.terminal, shortest[next.terminal]));
                }
            }
        }
        return String.valueOf(shortest[100] - 1);
    }

    private static class Edge {
        private final int terminal;
        private final int cost;

        public Edge(int terminal, int cost) {
            this.terminal = terminal;
            this.cost = cost;
        }
    }
}

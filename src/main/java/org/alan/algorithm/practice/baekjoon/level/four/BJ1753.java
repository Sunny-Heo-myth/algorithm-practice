package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1753 {
    private boolean[] check;    // initialized only once
    private int[] distance;
    private Map<Integer, List<ToCost>> connection;  // stateless

    public String solve(String input) {
        int start = parse(input);
        dijkstra(start);
        return IntStream.range(1, distance.length)
                .mapToObj(i -> distance[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(distance[i]))
                .collect(Collectors.joining("\n"));
    }

    private void dijkstra(int start) {
        Queue<ToCost> queue = new PriorityQueue<>(Comparator.comparingInt(tc -> tc.cost));

        distance[start] = 0;
        queue.offer(new ToCost(start, 0));

        while (!queue.isEmpty()) {
            int now = queue.poll().to;

            if (check[now]) continue;
            check[now] = true;

            for (ToCost next : connection.get(now)) {
                int nextCost = distance[now] + next.cost;
                if (distance[next.to] > nextCost) {
                    distance[next.to] = nextCost;
                    queue.offer(new ToCost(next.to, distance[next.to]));
                }
            }
        }
    }

    private int parse(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int numberOfVertix = Integer.parseInt(firstLine[0]);

        check = new boolean[numberOfVertix + 1];
        distance = new int[numberOfVertix + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        connection = new HashMap<>();
        for (int i = 0; i < Integer.parseInt(firstLine[0]); i++) connection.put(i + 1, new ArrayList<>());
        for (int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
            String[] ss = s[i + 2].split(" ");
            connection.get(Integer.parseInt(ss[0])).add(new ToCost(Integer.parseInt(ss[1]), Integer.parseInt(ss[2])));
        }
        return Integer.parseInt(s[1]);
    }

    private static class ToCost {
        private final int to;
        private final int cost;

        private ToCost(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}

package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.*;
import java.util.stream.IntStream;

public class BJ1504 {
    private final List<List<Node>> fromToCost = new ArrayList<>(); // stateless
    private int[] untilNow;
    private boolean[] check;
    private static final int NO_ROUTE = 200000000;

    public String solve(String input) {
        String[] s = input.split("\n");
        StringTokenizer st = new StringTokenizer(s[0]);
        int numberOfVertices = getInt(st);
        int numberOfEdges = getInt(st);

        IntStream.range(0, numberOfVertices + 1).forEach(i -> fromToCost.add(new ArrayList<>()));
        untilNow = new int[numberOfVertices + 1];
        check = new boolean[numberOfVertices + 1];

        for (int i = 0; i < numberOfEdges; i++) {
            st = new StringTokenizer(s[i + 1]);
            int from = getInt(st);
            int to = getInt(st);
            int cost = getInt(st);
            fromToCost.get(from).add(new Node(to, cost));
            fromToCost.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(s[numberOfEdges + 1]);
        int stopOver1 = getInt(st);
        int stopOver2 = getInt(st);

        int oneTwo = dijkstra(stopOver1, stopOver2);
        int route1 = oneTwo + dijkstra(1, stopOver1) + dijkstra(stopOver2, numberOfVertices);
        int route2 = oneTwo + dijkstra(1, stopOver2) + dijkstra(stopOver1, numberOfVertices);
        return String.valueOf(route1 >= NO_ROUTE && route2 >= NO_ROUTE ? -1 : Math.min(route1, route2));
    }

    private int dijkstra(int start, int end) {
        Arrays.fill(untilNow, NO_ROUTE);
        Arrays.fill(check, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        untilNow[start] = 0;

        while (!queue.isEmpty()) {
            int nowTo = queue.poll().to;

            if (check[nowTo]) continue;

            check[nowTo] = true;
            fromToCost.get(nowTo).stream()
                    .filter(next -> !check[next.to] && untilNow[next.to] > untilNow[nowTo] + next.cost)
                    .forEach(next -> {
                        untilNow[next.to] = untilNow[nowTo] + next.cost;
                        queue.add(new Node(next.to, untilNow[next.to]));
                    });
        }

        return untilNow[end];
    }

    private int getInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static class Node implements Comparable<Node> {
        private final int to;
        private final int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
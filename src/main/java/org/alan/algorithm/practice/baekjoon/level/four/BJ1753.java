package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.*;

public class BJ1753 {
    private final List<List<Vertix>> graph = new ArrayList<>();    // stateless
    private int[] cost;

    public String solve(String input) {
        int from = parse(input);
        dijkstra(from);
        return write();
    }

    private void dijkstra(int start) {
        PriorityQueue<Vertix> queue = new PriorityQueue<>(Comparator.comparingInt(vertix -> vertix.cost));
        boolean[] check = new boolean[cost.length];

        cost[start] = 0;
        queue.offer(new Vertix(start, cost[start]));

        while (!queue.isEmpty()) {
            Vertix current = queue.poll();
            int currentIndex = current.index;
            int currentCost = current.cost;

            if (check[currentIndex]) continue;
            check[currentIndex] = true;

            List<Vertix> nextList = graph.get(currentIndex);
            for (Vertix next : nextList) {
                int nextVertix = next.index;
                int nextCost = next.cost;

                if (cost[nextVertix] > currentCost + nextCost) {
                    cost[nextVertix] = currentCost + nextCost;
                    queue.offer(new Vertix(nextVertix, nextCost));
                }
            }
        }
    }

    private int parse(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");

        int numberOfVertices = Integer.parseInt(firstLine[0]);
        cost = new int[numberOfVertices + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i < cost.length; i++) graph.add(new ArrayList<>());


        int numberOfEdges = Integer.parseInt(firstLine[1]);
        for (int i = 0; i < numberOfEdges; i++) {
            int[] vertix = Arrays.stream(s[i + 2].split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(vertix[0]).add(new Vertix(vertix[1], vertix[2]));
        }

        return Integer.parseInt(s[1]);
    }

    private String write() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < cost.length; i++) sb.append(cost[i] == Integer.MAX_VALUE ? "INF" : cost[i]).append("\n");
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private class Vertix {
        private final int index;
        private final int cost;

        private Vertix(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}

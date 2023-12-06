package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.*;
import java.util.stream.IntStream;

public class BJ1916 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int numberOfVertices = Integer.parseInt(s[0]);
        int numberOfEdges = Integer.parseInt(s[1]);

        List<List<ToCost>> fromToCost = new ArrayList<>();  // stateless
        IntStream.range(0, numberOfVertices + 1).forEach(i -> fromToCost.add(new ArrayList<>()));
        IntStream.range(2, 2 + numberOfEdges).forEach(i -> {
            String[] ss = s[i].split(" ");
            fromToCost.get(Integer.parseInt(ss[0])).add(ToCost.of(Integer.parseInt(ss[1]), Integer.parseInt(ss[2])));
        });

        PriorityQueue<ToCost> queue = new PriorityQueue<>(Comparator.comparingInt(tc -> tc.cost));
        boolean[] check = new boolean[numberOfVertices + 1];
        int[] shortest = new int[numberOfVertices + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);

        String[] lastLine = s[2 + numberOfEdges].split(" ");
        queue.offer(ToCost.of(Integer.parseInt(lastLine[0]), 0));
        shortest[Integer.parseInt(lastLine[0])] = 0;

        while (!queue.isEmpty()) {
            ToCost now = queue.poll();
            if (check[now.to]) continue;

            check[now.to] = true;
            fromToCost.get(now.to).stream()
                    .filter(next -> !check[next.to] && shortest[now.to] + next.cost < shortest[next.to])
                    .forEach(next -> {
                        shortest[next.to] = shortest[now.to] + next.cost;
                        queue.add(ToCost.of(next.to, shortest[next.to]));
                    });
        }

        return String.valueOf(shortest[Integer.parseInt(lastLine[1])]);
    }

    private static class ToCost {
        private int to;
        private int cost;

        private static ToCost of(int to, int cost) {
            ToCost tc = new ToCost();
            tc.to = to;
            tc.cost = cost;
            return tc;
        }
    }
}

package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.*;
import java.util.stream.IntStream;

public class BJ16928 {
    public String solve(String input) {
        List<List<TermCost>> initTermCost = new ArrayList<>();
        int[][] cost = new int[101][101];

        IntStream.range(0, 101).forEach(i -> {
            IntStream.of(i + 1).limit(6).forEach(j -> initTermCost.get(i).add(new TermCost(Math.min(j, 100), 1)));
            initTermCost.add(new ArrayList<>());
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        });

        input.lines().skip(1).forEach(s -> {
            String[] ss = s.split(" ");
            initTermCost.get(Integer.parseInt(ss[0])).add(new TermCost(Integer.parseInt(ss[1]), 1));
        });

        Queue<TermCost> queue = new LinkedList<>();
        queue.offer(new TermCost(1, 0));
        while (!queue.isEmpty()) {
            TermCost now = queue.poll();

            for (TermCost next : initTermCost.get(now.cost)) {
                if (cost[now.term][next.term] == Integer.MAX_VALUE) {
                }
            }
        }
        return null;
    }


    private static class TermCost {
        private int term;
        private int cost;

        public TermCost(int term, int cost) {
            this.term = term;
            this.cost = cost;
        }
    }
}

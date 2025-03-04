package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.*;

public class BJ1949 {
    private final int[] pp;
    private final List<List<Integer>> graph = new ArrayList<>();

    public BJ1949(String input) {
        String[] lines = input.split("\n");
        pp = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < pp.length; i++) graph.add(new ArrayList<>());
        Arrays.stream(lines).skip(2)
                .map(line -> Arrays.stream(line.split(" ")).mapToInt(s -> Integer.parseInt(s) - 1).toArray())
                .forEach(edge -> {
                    graph.get(edge[0]).add(edge[1]);
                    graph.get(edge[1]).add(edge[0]);
                });
    }

    public String solve() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[pp.length];
        int[][] memo = new int[pp.length][2];

        stack.push(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int pt = stack.peek();

            if (graph.get(pt).stream().allMatch(ch -> visited[ch])) {
                memo[pt][1] = graph.get(pt).stream().mapToInt(ch1 -> memo[ch1][0]).sum() + pp[pt];
                memo[pt][0] = graph.get(pt).stream().mapToInt(ch1 -> memo[ch1][1] + graph.get(pt).stream()
                                .filter(ch2 -> !Objects.equals(ch1, ch2))
                                .mapToInt(ch2 -> Math.max(memo[ch2][0], memo[ch2][1]))
                                .sum())
                        .max().orElse(0);
                stack.pop();

            } else {
                for (int ch : graph.get(pt)) if (!visited[ch]) {
                    stack.push(ch);
                    visited[ch] = true;
                }
            }
        }
        return String.valueOf(Math.max(memo[0][0], memo[0][1]));
    }
}

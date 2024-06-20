package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1922 {
    private int[] parents;

    public String solve(String input) {
        int[][] edges = input.lines().skip(2).map(s -> {
            String[] word = s.split(" ");
            return new int[]{Integer.parseInt(word[0]) - 1, Integer.parseInt(word[1]) - 1, Integer.parseInt(word[2])};
        }).sorted(Comparator.comparingInt(ints -> ints[2])).toArray(int[][]::new);
        parents = IntStream.range(0, Integer.parseInt(input.split("\n")[0])).toArray();

        int totalCost = 0;
        for (int[] edge : edges) if (find(edge[0]) != find(edge[1])) {
            totalCost += edge[2];
            merge(edge[0], edge[1]);
        }
        return String.valueOf(totalCost);
    }

    public String solve2(String input) {
        parents = IntStream.rangeClosed(0, Integer.parseInt(input.split("\n")[0])).toArray();
        return String.valueOf(input.lines().skip(2)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .sorted(Comparator.comparingInt(ints -> ints[2]))
                .filter(edge -> find(edge[0]) != find(edge[1]))
                .peek(edge -> merge(edge[0], edge[1]))
                .reduce(0, (i, ints) -> i + ints[2], Integer::sum));
    }

    private int find(int child) {
        if (parents[child] == child) return child;
        return parents[child] = find(parents[child]);
    }

    private void merge(int child1, int child2) {
        int p1 = find(child1);
        int p2 = find(child2);
        if (p1 != p2) parents[p1] = p2;
    }
}

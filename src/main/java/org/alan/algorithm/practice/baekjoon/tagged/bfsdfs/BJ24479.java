package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BJ24479 {
    private final int R;
    private final int[] order;
    private final List<List<Integer>> graph = new ArrayList<>();
    private int n = 1;

    public BJ24479(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        R = Integer.parseInt(firstLine[2]);
        int N = Integer.parseInt(firstLine[0]);
        this.order = new int[N + 1];
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        Arrays.stream(lines).skip(1)
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
                .sorted((i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0])
                .forEach(ii -> {
                    graph.get(ii[0]).add(ii[1]);
                    graph.get(ii[1]).add(ii[0]);
                });
    }

    public String solve() {
        recur(R);
        return Arrays.stream(order).skip(1).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }

    private void recur(int node) {
        order[node] = n++;
        for (int next : graph.get(node)) if (order[next] == 0) recur(next);
    }
}

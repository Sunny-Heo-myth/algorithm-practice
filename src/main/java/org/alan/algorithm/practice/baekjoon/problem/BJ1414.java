package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class BJ1414 {
    private int[] parent;
    private int[] rank;

    public String solve(String input) {
        int[][] adjacency = input.lines().skip(1).map(s -> s.chars().map(i ->
                i == '0' ? 0 : i >= 'a' ?  i - 'a' + 1 : i - 'A' + 27).toArray()).toArray(int[][]::new);
        int n = adjacency.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2]));
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++)
            if (i != j && adjacency[i][j] != 0) pq.offer(new int[]{i, j, adjacency[i][j]});
        parent = IntStream.range(0, n).toArray();
        rank = new int[n];

        int sum = Arrays.stream(adjacency).mapToInt(ints -> Arrays.stream(ints).sum()).sum();
        int edgeCount = 0;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int root1 = find(node[0]), root2 = find(node[1]);
            if (root1 == root2) continue;
            union(root1, root2);
            sum -= node[2];
            edgeCount++;
        }
        if (edgeCount == n - 1) return String.valueOf(sum);
        else return "-1";
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int px, int py) {
        if (rank[px] > rank[py]) parent[py] = px;
        else if (rank[px] < rank[py]) parent[px] = py;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}

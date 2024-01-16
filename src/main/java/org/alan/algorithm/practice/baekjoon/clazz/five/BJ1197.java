package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1197 {
    private int total = 0;
    private int[] parentArray;
    private int[][] edgeArray;
    private PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2]));

    public String solve(String input) {
        parentArray = IntStream.rangeClosed(0, Integer.parseInt(new StringTokenizer(input).nextToken())).toArray();
        edgeArray = input.lines().skip(1).map(
                s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .peek(pq::offer).toArray(int[][]::new);

        for (int i = 0; i < edgeArray.length; i++) {
            int[] edge = pq.poll();
            int to = find(edge[1]);
            int from = find(edge[0]);
            if (!isSameParent(to, from)) {
                total += edge[2];
                union(edge[1], edge[0]);
            }
        }
        return String.valueOf(total);
    }

    private int find(int x) {
        if (parentArray[x] == x) return x;
        return parentArray[x] = find(parentArray[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parentArray[y] = x;
    }

    private boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

}

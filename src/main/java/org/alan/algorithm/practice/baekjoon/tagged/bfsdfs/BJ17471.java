package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ17471 {
    private int N;
    private int[] POPULATIONS;
    private boolean[][] GRAPH;

    public String solve(String input) {
        String[] lines = input.split("\n");
        N = Integer.parseInt(lines[0]);
        POPULATIONS = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();
        GRAPH = new boolean[N][N];
        for (int from = 0; from < N; from++) for (int to :
                Arrays.stream(lines[from + 2].split(" ")).skip(1).mapToInt(Integer::parseInt).toArray()) {
            GRAPH[from][to - 1] = true;
            GRAPH[to - 1][from] = true;
        }

        int totalSet = (1 << N) - 1;
        return String.valueOf(IntStream.range(1, totalSet)
                .filter(subset -> isConnected(subset) && isConnected(totalSet ^ subset))
                .map(subset -> Math.abs(sum(subset) - sum(totalSet ^ subset)))
                .min().orElse(-1));
    }

    private boolean isConnected(int set) {
        OptionalInt start = IntStream.range(0, N)
                .filter(i -> (set & (1 << i)) != 0)
                .findFirst();
        if (start.isEmpty()) return false;

        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();

        int count = 1;
        visited[start.getAsInt()] = true;
        queue.offer(start.getAsInt());
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next = 0; next < N; next++) if (GRAPH[now][next] && !visited[next] && (set & (1 << next)) != 0) {
                count++;
                visited[next] = true;
                queue.offer(next);
            }
        }

        return Integer.bitCount(set) == count;
    }

    private int sum(int set) {
        return IntStream.range(0, N)
                .filter(i -> (set & (1 << i)) != 0)
                .map(i -> POPULATIONS[i])
                .sum();
    }

}

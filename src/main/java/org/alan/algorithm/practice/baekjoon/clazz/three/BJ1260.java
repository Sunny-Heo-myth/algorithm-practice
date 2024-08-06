package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BJ1260 {
    private int numberOfVertices;
    private boolean[][] edges;
    private boolean[] visited;
    private final StringBuilder sb = new StringBuilder();

    public String solve(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        numberOfVertices = Integer.parseInt(firstLine[0]);
        edges = new boolean[numberOfVertices + 1][numberOfVertices + 1];
        visited = new boolean[numberOfVertices + 1];

        Arrays.stream(s).skip(1).forEach(ss -> {
            String[] sss = ss.split(" ");
            int e1 = Integer.parseInt(sss[0]);
            int e2 = Integer.parseInt(sss[1]);
            edges[e1][e2] = true;
            edges[e2][e1] = true;
        });

        int start = Integer.parseInt(firstLine[2]);
        dfs(start);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(start);
        return sb.toString();
    }

    private void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (visited[now]) continue;

            visited[now] = true;
            sb.append(now).append(" ");
            for (int next = numberOfVertices; next >= 1; next--) if (edges[now][next]) stack.push(next);
        }

    }

    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[now]) continue;

            visited[now] = true;
            sb.append(now).append(" ");
            for (int i = 1; i <= numberOfVertices; i++) if (edges[now][i]) queue.offer(i);
        }
    }

}

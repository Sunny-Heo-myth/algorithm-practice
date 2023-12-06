package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.Stack;

public class BJ11724 {
    private boolean[] nodes;
    private boolean[][] edges;  // state does not change.
    private Stack<Integer> stack;   // initiates after count
    private int count = 0;

    public String solve(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int numberOfNodes = Integer.parseInt(firstLine[0]);
        int numberOfEdges = Integer.parseInt(firstLine[1]);
        nodes = new boolean[numberOfNodes + 1]; // index refers node number
        edges = new boolean[numberOfNodes + 1][numberOfNodes + 1];
        for (int i = 0; i < numberOfEdges; i++) {   // for loop always starts with 0
            String[] line = s[i + 1].split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            edges[x][y] = true;
            edges[y][x] = true;
        }

        for (int i = 0; i < numberOfNodes; i++) if (!nodes[i + 1]) dfs(i + 1);  // for loop always starts with 0
        return String.valueOf(count);
    }

    private void dfs(int start) {
        count++;
        stack = new Stack<>();
        mark(start);
        while (!stack.isEmpty()) {
            int from = stack.pop();
            for (int to = 1; to < nodes.length; to++) {
                if (edges[from][to] && !nodes[to]) {
                    mark(to);
                }
            }
        }
    }

    private void mark(int start) {
        stack.push(start);
        nodes[start] = true;
    }
}

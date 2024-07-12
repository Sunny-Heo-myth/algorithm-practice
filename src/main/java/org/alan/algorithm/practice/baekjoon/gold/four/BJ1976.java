package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ1976 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int n = Integer.parseInt(lines[0]);
        int[][] adjacency = Arrays.stream(lines).skip(2).limit(n).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        boolean[] visited = new boolean[n];
        int[] groups = new int[n]; int groupNumber = 0;

        for (int i = 0; i < n; i++) if (!visited[i]) {
            Stack<Integer> stack = new Stack<>();

            stack.push(i);
            visited[i] = true;
            groups[i] = ++groupNumber;

            while (!stack.isEmpty()) {
                int pop = stack.pop();
                for (int next = 0; next < n; next++) if (adjacency[pop][next] == 1 && !visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                    groups[next] = groupNumber;
                }
            }
        }

        return Arrays.stream(lines).skip(2 + n).findFirst().stream().flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(ss -> groups[Integer.parseInt(ss) - 1])).sum()
                % lines[2 + n].split(" ").length == 0 ? "YES" : "NO";
    }
}

package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ20303 {
    public String solve(String input) {
        int cry = Integer.parseInt(input.split("\n")[0].split(" ")[2]);
        int[] children = input.lines().skip(1).findFirst().stream().flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream("0 " + s).mapToInt(Integer::parseInt)).toArray();
        boolean[] visited = new boolean[children.length]; visited[0] = true;

        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < children.length; i++) adjacency.add(new ArrayList<>());
        input.lines().skip(2)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .forEach(edge -> {adjacency.get(edge[0]).add(edge[1]); adjacency.get(edge[1]).add(edge[0]);});

        List<int[]> groups = new ArrayList<>();
        for (int root = 0; root < children.length; root++) if (!visited[root]) {
            int[] nsum = new int[2];
            Stack<Integer> stack = new Stack<>();

            visited[root] = true;
            nsum[0]++; nsum[1] += children[root];
            stack.push(root);

            while (!stack.isEmpty()) for (int to : adjacency.get(stack.pop())) if (!visited[to]) {
                visited[to] = true;
                nsum[0]++; nsum[1] += children[to];
                stack.push(to);
            }
            groups.add(nsum);
        }

        int[] memo = new int[cry];
        for (int[] nsum : groups) {
            int n = nsum[0]; int sum = nsum[1];
            for (int i = cry - 1; i >= n; i--) memo[i] = Math.max(memo[i], memo[i - n] + sum);
        }
        return String.valueOf(memo[cry - 1]);
    }
}

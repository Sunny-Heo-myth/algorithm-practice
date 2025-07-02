package org.alan.algorithm.practice.baekjoon.barkingdog.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BJ2533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        int[][] memo = new int[n][2];
        boolean[] visited = new boolean[n];

        while (n-- > 1) {
            String s = br.readLine();
            String[] ss = s.split(" ");
            int from = Integer.parseInt(ss[0]) - 1, to = Integer.parseInt(ss[1]) - 1;

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Stack<Integer> subProblems = new Stack<>();
        subProblems.push(0);
        while (!subProblems.isEmpty()) {
            int p = subProblems.peek();
            visited[p] = true;

            List<Integer> children = graph.get(p);
            if (children.stream().anyMatch(child -> !visited[child])) {
                children.stream()
                        .filter(child -> !visited[child])
                        .forEach(subProblems::push);
                continue;
            }

            memo[p][0] = children.stream().mapToInt(child -> memo[child][1]).sum();
            memo[p][1] = children.stream().mapToInt(child -> Math.min(memo[child][0], memo[child][1])).sum() + 1;
            subProblems.pop();
        }

        System.out.println(Math.min(memo[0][0], memo[0][1]));
    }
}

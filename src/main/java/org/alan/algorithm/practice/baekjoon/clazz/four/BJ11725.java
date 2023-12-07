package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ11725 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int numberOfNodes = Integer.parseInt(s[0]);

        boolean[] visited = new boolean[numberOfNodes + 1];
        int[] parents = new int[numberOfNodes + 1];
        List<List<Integer>> tree = new ArrayList<>();

        IntStream.range(0, numberOfNodes + 1).forEach(i -> tree.add(new ArrayList<>()));
        IntStream.range(1, numberOfNodes).forEach(i -> {
            String[] ss = s[i].split(" ");
            int initial = Integer.parseInt(ss[0]);
            int terminal = Integer.parseInt(ss[1]);
            tree.get(initial).add(terminal);
            tree.get(terminal).add(initial);
        });

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : tree.get(parent)) {
                if (visited[child]) continue;
                visited[child] = true;
                parents[child] = parent;
                queue.add(child);
            }
        }

        return Arrays.stream(parents).mapToObj(String::valueOf)
                .collect(Collectors.joining("\n")).substring(4);
    }
}

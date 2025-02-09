package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ1516 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int N = Integer.parseInt(lines[0]);

        int[] takes = new int[N + 1];
        List<List<Integer>> fromTo = new ArrayList<>();
        for (int i = 0; i <= N; i++) fromTo.add(new ArrayList<>());

        Queue<Integer> queue = new LinkedList<>();
        int[] memo = new int[N + 1];
        for (int to = 1; to <= N; to++) {
            int[] b = Pattern.compile(" ").splitAsStream(lines[to]).mapToInt(Integer::parseInt).toArray();
            takes[to] = b[0];
            if (b.length == 2) {
                queue.offer(to);
                memo[to] = takes[to];
            } else for (int from = 1; from < b.length - 1; from++) fromTo.get(b[from]).add(to);
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : fromTo.get(from)) {
                if (memo[to] >= memo[from] + takes[to]) continue;
                queue.offer(to);
                memo[to] = memo[from] + takes[to];
            }
        }
        return Arrays.stream(memo).skip(1).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
    }
}

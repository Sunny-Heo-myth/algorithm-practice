package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1325 {
    public String solve(String input) {
        Map<Integer, List<Integer>> tt = new HashMap<>();
        int n = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
        IntStream.rangeClosed(1, n)
                .forEach(i -> tt.put(i, new ArrayList<>()));
        input.lines().skip(1).forEach(s -> {
            String[] ss = s.split(" ");
            tt.get(Integer.parseInt(ss[1])).add(Integer.parseInt(ss[0]));
        });

        int max = -1;
        List<Integer> answer = new ArrayList<>();
        for (int root : tt.keySet()) {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[n + 1];

            int count = 0;
            stack.push(root);   // st
            visited[root] = true;   // st

            while (!stack.isEmpty()) {
                int pop = stack.pop();     // st

                for (int child : tt.get(pop)) {
                    if (visited[child]) continue;

                    count++;    // st
                    stack.push(child);   // st
                    visited[child] = true;   // st
                }
            }

            if (count == max) {
                answer.add(root);    // st
                continue;
            }

            if (count > max) {
                max = count;    // st
                answer.clear();    // st
                answer.add(root);    // st
            }

        }

        return answer.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
    }
}

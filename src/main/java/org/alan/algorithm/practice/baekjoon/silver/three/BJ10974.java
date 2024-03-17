package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BJ10974 {
    private boolean[] visited;
    private final List<String> answer = new ArrayList<>();
    private final Stack<Integer> stack = new Stack<>();

    public String solve(String input) {
        visited = new boolean[Integer.parseInt(input)];
        recur(0);
        return String.join("\n", answer);
    }

    private void recur(int count) {
        if (count == visited.length) {
            answer.add(stack.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            stack.push(i + 1);
            recur(count + 1);
            visited[i] = false;
            stack.pop();
        }
    }
}

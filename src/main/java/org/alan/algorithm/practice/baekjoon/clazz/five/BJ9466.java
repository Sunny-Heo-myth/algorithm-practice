package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ9466 {

    private int[] want;
    private boolean[] visited;
    private boolean[] finished;
    private int count;

    public String solve2(String input) {
        want = Pattern.compile(" ").splitAsStream("0 " + input.split("\n")[1]).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[want.length];
        finished = new boolean[want.length];
        count = 0;

        for (int i = 1; i < want.length; i++) dfs(i);
        return String.valueOf(want.length - 1 - count);
    }

    private void dfs(int now) {
        if(visited[now]) return;

        visited[now] = true;
        int next = want[now];

        if (!visited[next]) dfs(next);
        else if (!finished[next]) {
            count++;
            for (int i = next; i != now; i = want[i]) count++;
        }

        finished[now] = true;
    }
}
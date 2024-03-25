package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;

public class BJ10451 {
    private int[] pmt;
    private boolean[] visited;

    public String solve(String input) {
        pmt = Pattern.compile(" ").splitAsStream("0 " + input.split("\n")[1]).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[pmt.length + 1];

        int count = 0;
        for (int i = 1; i < pmt.length; i++) {
            if (visited[i]) continue;
            count++;
            recur(i);
        }
        return String.valueOf(count);
    }

    private void recur(int idx) {
        if (visited[idx]) return;
        visited[idx] = true;
        recur(pmt[idx]);
    }
}

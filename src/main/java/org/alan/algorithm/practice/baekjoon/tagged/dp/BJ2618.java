package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ2618 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int N = Integer.parseInt(lines[0]), W = Integer.parseInt(lines[1]), UNSOLVED = -1;
        int[][] events = new int[W + 1][2];
        for (int i = 1; i <= W; i++)
            events[i] = Pattern.compile(" ").splitAsStream(lines[i + 1]).mapToInt(Integer::parseInt).toArray();

        int[][] tMemo = new int[W + 1][W + 1], pMemo = new int[W + 1][W + 1];
        for (int i = 0; i < W; i++) for (int j = 0; j < W; j++) tMemo[i][j] = UNSOLVED;
        Stack<int[]> subps = new Stack<>();

        subps.push(new int[]{0, 0});
        while (!subps.isEmpty()) {
            int[] peek = subps.peek();
            int p1e = peek[0], p2e = peek[1], ne = Math.max(p1e, p2e) + 1;

            if (tMemo[ne][p2e] != UNSOLVED && tMemo[p1e][ne] != UNSOLVED) {
                int p1x = p1e == 0 ? 1 : events[p1e][0], p1y = p1e == 0 ? 1 : events[p1e][1];
                int p2x = p2e == 0 ? N : events[p2e][0], p2y = p2e == 0 ? N : events[p2e][1];
                int p1n = Math.abs(p1x - events[ne][0]) + Math.abs(p1y - events[ne][1]) + tMemo[ne][p2e];
                int p2n = Math.abs(p2x - events[ne][0]) + Math.abs(p2y - events[ne][1]) + tMemo[p1e][ne];
                tMemo[p1e][p2e] = Math.min(p1n, p2n);
                pMemo[p1e][p2e] = p1n <= p2n ? 1 : 2;
                subps.pop();
                continue;
            }

            if (tMemo[ne][p2e] == UNSOLVED) subps.push(new int[]{ne, p2e});
            if (tMemo[p1e][ne] == UNSOLVED) subps.push(new int[]{p1e, ne});
        }

        StringBuilder sb = new StringBuilder(tMemo[0][0] + "\n");
        int p1e = 0, p2e = 0;
        for (int e = 1; e <= W; e++) {
            boolean b = pMemo[p1e][p2e] == 1;
            sb.append(b ? 1 : 2).append("\n");
            if (b) p1e = e;
            else p2e = e;
        }
        return sb.toString();
    }
}

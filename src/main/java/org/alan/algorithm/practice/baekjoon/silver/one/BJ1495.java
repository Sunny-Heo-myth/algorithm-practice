package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ1495 {
    public String solve(String input) {
        int[][] a = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                        .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int n = a[0][0]; int start = a[0][1]; int vMax = a[0][2]; int[] volumes = a[1];

        boolean[][] memo = new boolean[n][vMax + 1];
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{0, start});    // do not memo since first song doesn't count.
        while (!stack.isEmpty()) {
            int[] pop = stack.pop(); int song = pop[0]; int volume = pop[1];
            if (song == n) continue;

            int down = volume - volumes[song];
            if (down >= 0 && !memo[song][down]) {
                memo[song][down] = true;
                stack.push(new int[]{song + 1, down});
            }

            int up = volume + volumes[song];
            if (up <= vMax && !memo[song][up]) {
                memo[song][up] = true;
                stack.push(new int[]{song + 1, up});
            }
        }

        for (int i = vMax; i >= 0; i--) if (memo[n - 1][i]) return String.valueOf(i);
        return "-1";
    }
}

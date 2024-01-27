package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ2098 {
    private static final int MAXIMUM = 16_000_000;
    private int[][] cost, memo;

    public String solve(String input) {
        cost = input.lines().skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        memo = new int[cost.length][(1 << cost.length) - 1];    // minimum route from some city while visited all 1 bit cities
        for (int i = 0; i < cost.length; i++) Arrays.fill(memo[i], -1);

        return String.valueOf(dfs(0, 1));   // start from 0 (order doesn't matter) 1: visited first city
    }

    private int dfs(int now, int visitBit) {
        if (visitBit == (1 << cost.length) - 1) // if all bit is 1
            if (cost[now][0] != 0) return cost[now][0]; // If it can come back from now to the first
            else return MAXIMUM;

        if (memo[now][visitBit] != -1) return memo[now][visitBit];  // if already visited return the value
        memo[now][visitBit] = MAXIMUM;  // mark as visited

        for (int next = 0; next < cost.length; next++) if ((visitBit & (1 << next)) == 0 && cost[now][next] != 0)
            memo[now][visitBit] = Math.min(memo[now][visitBit], dfs(next, visitBit | (1 << next)) + cost[now][next]);
        return memo[now][visitBit];
    }

}

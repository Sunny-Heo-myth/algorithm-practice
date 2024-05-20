package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.Arrays;

public class BJ2294 {

    public String solve2(String input) {
        int k = Integer.parseInt(input.split("\n")[0].split(" ")[1]); int UNREACHED = Integer.MAX_VALUE;
        int[] coins = input.lines().skip(1).mapToInt(Integer::parseInt).distinct().sorted().toArray();
        int[] memo = new int[k + 1]; Arrays.fill(memo, UNREACHED); memo[0] = 0;
        for (int coin : coins) for (int sum = coin; sum <= k; sum++)
            memo[sum] = Math.min(memo[sum], memo[sum - coin] == UNREACHED ? UNREACHED : memo[sum - coin] + 1);
        return memo[k] == UNREACHED ? "-1" : String.valueOf(memo[k]);
    }
}

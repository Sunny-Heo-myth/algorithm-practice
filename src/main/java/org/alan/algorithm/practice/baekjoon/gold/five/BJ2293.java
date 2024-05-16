package org.alan.algorithm.practice.baekjoon.gold.five;

public class BJ2293 {   // todo:
    public String solve(String input) {
        int k = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
        int[] coins = input.lines().skip(1).mapToInt(Integer::parseInt).toArray();
        int[] memo = new int[k + 1]; memo[0] = 1;
        for (int coin : coins) for (int sum = coin; sum <= k; sum++) memo[sum] += memo[sum - coin];
        return String.valueOf(memo[k]);
    }
}

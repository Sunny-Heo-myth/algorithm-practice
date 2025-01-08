package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import java.util.regex.Pattern;

public class BJ9084 {

    public String solve(String input) {
        String[] lines = input.split("\n");
        int[] coins = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();
        int[] memo = new int[Integer.parseInt(lines[2]) + 1];

        // initiation: Making 0 takes no coin thus there is only a way.
        // before: All possible way to make the amount of money with the given range of coin excluding 'coin' has been considered.
        // after: All possible way to make the amount of money with the given range of coin including 'coin' has been considered.
        // termination: Each element of memo represents the number of ways to make the indexed amount of money.
        memo[0] = 1;
        for (int coin : coins) for (int money = coin; money < memo.length; money++) memo[money] += memo[money - coin];
        return String.valueOf(memo[memo.length - 1]);
    }

}

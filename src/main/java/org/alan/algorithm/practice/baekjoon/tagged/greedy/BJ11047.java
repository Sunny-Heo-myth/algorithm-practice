package org.alan.algorithm.practice.baekjoon.tagged.greedy;

public class BJ11047 {
    private int[] coins;

    public String solve(String input) {
        int money = parse(input);
        return String.valueOf(countCoin(money));
    }

    private int countCoin(int money) {
        int left = money;
        int count = 0;
        while (left != 0) for (int coin : coins) if (left >= coin) {
            count += left / coin;
            left %= coin;
        }
        return count;
    }

    private int parse(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int numberOfType = Integer.parseInt(firstLine[0]);
        coins = new int[numberOfType];
        for (int i = 0; i < numberOfType; i++) coins[numberOfType - 1 - i] = Integer.parseInt(s[i + 1]);
        return Integer.parseInt(firstLine[1]);
    }
}

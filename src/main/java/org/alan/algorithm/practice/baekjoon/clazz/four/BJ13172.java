package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.regex.Pattern;

public class BJ13172 {
    private static final int DIVISOR = 1000000007;

    public String solve(String input) {
        int[][] dices = input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        long denominator = 1, nominator = 0;
        for (int[] dice : dices) {
            int numberOfSurface = dice[0];
            int diceSum = dice[1];
            nominator = diceSum * denominator + nominator * numberOfSurface;
            denominator *= numberOfSurface;
            nominator %= DIVISOR;
            denominator %= DIVISOR;
        }

        if (nominator % denominator != 0) return String.valueOf((search(denominator, DIVISOR - 2) * nominator) % DIVISOR);
        else return String.valueOf(nominator / denominator);
    }

    private long search(long N, int index) {
        if (index == 1) return N;
        long temp = search(N, index / 2);
        if (index % 2 == 1) return temp * temp % DIVISOR * N % DIVISOR;
        else return temp * temp % DIVISOR;
    }
}

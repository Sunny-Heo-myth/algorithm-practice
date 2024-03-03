package org.alan.algorithm.practice.baekjoon.silver;

public class BJ1475 {
    public String solve(String input) {
        int[] decimalCount = new int[10];
        input.chars().map(i -> i - '0').forEach(i -> decimalCount[i]++);
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }

            max = Math.max(decimalCount[i], max);
        }

        int min = Math.min(decimalCount[6], decimalCount[9]);
        int abs = Math.abs(decimalCount[6] - decimalCount[9]);
        int sixNine = abs % 2 == 0 ? abs / 2 : abs / 2 + 1;
        int maxFor69 = sixNine + min;

        return String.valueOf(Math.max(maxFor69, max));
    }

}

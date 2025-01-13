package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import java.util.stream.IntStream;

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

    public String solve2(String input) {
        int[] numbers = new int[10];
        input.chars().map(i -> i - '0').forEach(i -> numbers[i]++);
        int max69 = (numbers[6] + numbers[9]) / 2 + ((numbers[6] + numbers[9]) % 2 == 1 ? 1 : 0);
        int maxWithout69 = IntStream.of(0, 1, 2, 3, 4, 5, 7, 8).map(i -> numbers[i]).max().orElse(-1);
        return String.valueOf(Math.max(max69, maxWithout69));
    }
}

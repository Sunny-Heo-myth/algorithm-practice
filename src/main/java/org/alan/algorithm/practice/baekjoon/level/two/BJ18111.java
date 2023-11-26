package org.alan.algorithm.practice.baekjoon.level.two;

import java.util.Arrays;

public class BJ18111 {

    public String solve(String input) {
        String[] lines = input.split("\n");
        int initialInventory = Integer.parseInt(lines[0].split(" ")[2]);
        int[][] ground = Arrays.stream(lines).skip(1)
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        
        int max = Arrays.stream(ground).flatMapToInt(Arrays::stream).max().orElse(256);
        int min = Arrays.stream(ground).flatMapToInt(Arrays::stream).min().orElse(0);

        int totalTime = Integer.MAX_VALUE;
        int highestBase = Integer.MIN_VALUE;
        for (int base = max; base >= min; base--) {
            int time = 0;
            int inventory = initialInventory;
            for (int[] row : ground) for (int block : row) {
                if (block > base) {
                    time += 2 * (block - base);
                    inventory += block - base;
                } else if (block < base) {
                    time += (base - block);
                    inventory -= base - block;
                }
            }

            if (inventory >= 0 && totalTime > time) {
                totalTime = time;
                highestBase = base;
            }
        }

        return totalTime + " " + highestBase;
    }

}

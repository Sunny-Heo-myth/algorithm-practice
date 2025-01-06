package org.alan.algorithm.practice.baekjoon.problem;

import java.util.OptionalInt;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ4883 {
    private int problem = 0;

    public String solve(String input) {
        int[][] map = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int xx = map.length;
        map[0][0] = Integer.MAX_VALUE; map[0][2] += map[0][1];

        for (int x = 1; x < xx; x++) for (int y = 0; y < 3; y++) {
            OptionalInt cd = switch (y) {
                case 0 -> IntStream.of(map[x - 1][y], map[x - 1][y + 1]).min();
                case 1 -> IntStream.of(map[x][y - 1], map[x - 1][y - 1], map[x - 1][y], map[x - 1][y + 1]).min();
                case 2 -> IntStream.of(map[x][y - 1], map[x - 1][y - 1], map[x - 1][y]).min();
                default -> throw new IllegalArgumentException();
            };
            map[x][y] += cd.orElse(Integer.MIN_VALUE);
        }

        return ++problem + ". " + map[xx - 1][1];
    }
}

package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ17144 {
    private int[][] map;
    private int[] cleaner;
    private static final int[] DX = {1, 0 ,-1, 0};
    private static final int[] DY = {0 ,-1, 0, 1};

    public String solve(String input) {
        int time = input.lines().findFirst().stream().mapToInt(s -> Integer.parseInt(s.split(" ")[2])).sum();
        map = input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        cleaner = IntStream.range(0, map.length).filter(i -> map[i][0] == -1).toArray();

        while (time-- > 0) {
            diffuse();
            circulate();
        }
        return String.valueOf(Arrays.stream(map).flatMapToInt(Arrays::stream).sum() + 2);
    }

    private void diffuse() {
    }

    private void circulate() {
        int column = map[0].length;
        int up = cleaner[0];
        IntStream.iterate(up - 2, i -> i >= 0, i -> i - 1).forEach(i -> map[i + 1][0] = map[i][0]);
        IntStream.iterate(1, i -> i < column, i -> i + 1).forEach(i -> map[0][i - 1] = map[0][i]);
        IntStream.iterate(1, i -> i <= up, i -> i + 1).forEach(i -> map[i - 1][column - 1] = map[i][column - 1]);
        IntStream.iterate(column - 2, i -> i > 0, i -> i - 1).forEach(i -> map[up][i + 1] = map[up][i]);
        map[up][1] = 0;

        int row = map.length;
        int down = cleaner[1];
        IntStream.iterate(down - 2, i -> i < row, i -> i + 1).forEach(i -> map[i - 1][0] = map[i][0]);
        IntStream.iterate(1, i -> i < column, i -> i + 1).forEach(i -> map[row - 1][i - 1] = map[row - 1][i]);
        IntStream.iterate(column - 2, i -> i > 0, i -> i - 1).forEach(i -> map[up][i + 1] = map[up][i]);
        IntStream.iterate(row - 2, i -> i > down, i -> i - 1).forEach(i -> map[i][0] = map[i + 1][0]);
        map[down][1] = 0;
    }

}

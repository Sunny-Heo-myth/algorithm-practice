package org.alan.algorithm.practice.baekjoon.stepbystep.divideconquer;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1780 {
    private int[][] arr;
    private int minus = 0;
    private int zero = 0;
    private int plus = 0;

    public String solve(String input) {
        arr = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        recur(0, 0, arr.length);
        return minus + "\n" + zero + "\n" + plus;
    }

    private void recur(int x, int y, int size) {
        if (IntStream.range(x, x + size).allMatch(i ->
                IntStream.range(y, y + size).noneMatch(j -> arr[i][j] != arr[x][y]))) {
            switch (arr[x][y]) {
                case 1 -> plus++;
                case 0 -> zero++;
                case -1 -> minus++;
            }
            return;
        }

        for (int i = x; i < x + size; i += size / 3)
            for (int j = y; j < y + size; j += size / 3) recur(i, j, size / 3);
    }

}

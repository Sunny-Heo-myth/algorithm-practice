package org.alan.algorithm.practice.baekjoon.tagged.bt;

import java.util.stream.IntStream;

public class BJ17136 {
    private final boolean[][] map = new boolean[10][10];
    private final int[] papers = {0, 5, 5, 5, 5, 5};
    private int min = 26;

    public BJ17136(String input) {
        String[] lines = input.lines().toArray(String[]::new);
        for (int i = 0; i < 10; i++) {
            String[] chars = lines[i].split(" ");
            for (int j = 0; j < 10; j++) if (chars[j].equals("1")) {
                map[i][j] = true;
            }
        }
    }

    public String solve() {
        recur(0, 0, 0);
        return String.valueOf(min == 26 ? -1 : min);
    }

    private void recur(int x, int y, int count) {
        if (count >= min) return;

        if (x == 10) {
            min = Math.min(min, count);
            return;
        }

        if (y == 10) {
            recur(x + 1, 0, count);
            return;
        }

        if (!map[x][y]) {
            recur(x, y + 1, count);
            return;
        }

        paper: for (int p = IntStream.of(5, 10 - x, 10 - y).min().orElse(1); p > 0; p--) {
            for (int i = x; i < x + p; i++) for (int j = y; j < y + p; j++) if (!map[i][j]) continue paper;
            if (papers[p] == 0) continue;

            for (int i = x; i < x + p; i++) for (int j = y; j < y + p; j++) map[i][j] = false;
            papers[p]--;

            recur(x, y + 1, count + 1);

            for (int a = x; a < x + p; a++) for (int b = y; b < y + p; b++) map[a][b] = true;
            papers[p]++;
        }
    }

}

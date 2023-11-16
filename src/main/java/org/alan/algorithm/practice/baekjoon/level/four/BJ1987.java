package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.regex.Pattern;

public class BJ1987 {
    private char[][] map;   // stateless
    private final boolean[] visited = new boolean[26];
    private int max = 1;

    private static final int[] toX = {1, 0, -1, 0};
    private static final int[] toY = {0, 1, 0, -1};

    public String solve(String input) {
        map = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(String::toCharArray)
                .toArray(char[][]::new);
        
        run(new int[]{0, 0, 0});

        return String.valueOf(max);
    }

    private void run(int[] now) {
        if (visited[getChar(now)]) {
            max = Integer.max(max, now[2]);
            return;
        }

        visited[getChar(now)] = true;

        for (int i = 0; i < 4; i++) {
            int[] next = {now[0] + toX[i], now[1] + toY[i], now[2] + 1};
            if (next[0] < 0 || next[0] >= map.length || next[1] < 0 || next[1] >= map[0].length) continue;
            run(next);
        }

        visited[getChar(now)] = false;
    }

    private int getChar(int[] next) {
        return map[next[0]][next[1]] - 65;
    }

}

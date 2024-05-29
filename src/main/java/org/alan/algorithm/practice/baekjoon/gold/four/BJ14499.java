package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ14499 {
    private final int[] dice = new int[7];
    private int[][] map;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    public String solve(String input) {
        String[] lines = input.split("\n");
        int[] fl = Arrays.stream(lines[0].split(" ")).mapToInt(Integer::parseInt).toArray();
         map = input.lines().skip(1).limit(fl[0]).map(s -> Pattern.compile(" ")
                .splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int[] ops = Pattern.compile(" ").splitAsStream(lines[1 + fl[0]]).mapToInt(Integer::parseInt).toArray();

        List<Integer> answer = new ArrayList<>();
        int x = fl[2]; int y = fl[3];
        for (int op : ops) {
            int nx = x + dx[op - 1]; int ny = y + dy[op - 1];
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
            answer.add(roll(op, nx, ny));
            x = nx; y = ny;
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }

    private int roll(int d, int x, int y) {
        int tmp = dice[3];
        switch (d) {
            case 1: dice[3] = dice[2]; dice[2] = dice[6]; dice[6] = dice[4]; dice[4] = tmp; break;
            case 2: dice[3] = dice[4]; dice[4] = dice[6]; dice[6] = dice[2]; dice[2] = tmp; break;
            case 3: dice[3] = dice[5]; dice[5] = dice[6]; dice[6] = dice[1]; dice[1] = tmp; break;
            case 4: dice[3] = dice[1]; dice[1] = dice[6]; dice[6] = dice[5]; dice[5] = tmp; break;
        }

        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        return dice[3];
    }
}

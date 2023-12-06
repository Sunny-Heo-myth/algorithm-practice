package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class BJ14940 {
    private final int[] xx = {1, 0, -1, 0};
    private final int[] yy = {0, -1, 0, 1};
    private final Queue<int[]> queue = new LinkedList<>();
    private int[][] map;
    private int[][] answer;


    public String solve(String input) {
        int[] start = parse(input);
        queue.offer(start);
        mark();
        // add -1 for unavailable spot
        unavailable();
        answer[start[0]][start[1]] = 0;
        return write(answer);
    }

    private void unavailable() {
        for (int i = 0; i < answer.length; i++) for (int j = 0; j < answer[0].length; j++)
                if (answer[i][j] == 0 && map[i][j] != 0) answer[i][j] = -1;
    }

    private void mark() {
        int count = 1;
        while (!queue.isEmpty()) {
            int[] from = queue.poll();
            move(from);
        }
    }

    private void move(int[] from) {
        for (int i = 0; i < 4; i++) {
            int toX = from[0] + xx[i];
            int toY = from[1] + yy[i];

            if (toX < 0 || toX >= map.length || toY < 0 || toY >= map[0].length) continue;

            if (map[toX][toY] != 0 && answer[toX][toY] == 0) {
                answer[toX][toY] = answer[from[0]][from[1]] + 1;
                queue.offer(new int[]{toX, toY});
            }
        }
    }

    private int[] parse(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int x = Integer.parseInt(firstLine[0]);
        int y = Integer.parseInt(firstLine[1]);
        int[] start = new int[2];
        map = new int[x][y];
        answer = new int[x][y];
        for (int i = 0; i < x; i++)
            map[i] = Arrays.stream(s[i + 1].split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        for (int i = 0; i < x; i++) for (int j = 0; j < y; j++) if (map[i][j] == 2) return new int[]{i, j};
        return start;
    }

    private String write(int[][] multiply) {
        return Arrays.stream(multiply)
                .map(ints -> Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }
}

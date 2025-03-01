package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ17142 {

    public String solve(String input) {
        String[] lines = input.split("\n");
        int EMPTY = 0, WALL = 1, VIRUS = 2, M = Integer.parseInt(lines[0].split(" ")[1]), E = 0;
        int[] DX = {1, -1, 0, 0}, DY = {0, 0, 1, -1};
        int[][] MAP = new int[lines.length - 1][lines.length - 1];
        List<int[]> VIRUSES = new ArrayList<>();
        for (int i = 0; i < lines.length - 1; i++) {
            int[] line = Arrays.stream(lines[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < line.length; j++) {
                MAP[i][j] = line[j];
                if (MAP[i][j] == EMPTY) E++;
                if (MAP[i][j] == VIRUS) VIRUSES.add(new int[]{i, j});
            }
        }
        if (E == 0) return "0";

        int min = Integer.MAX_VALUE;
        int[] actives = IntStream.rangeClosed(1, M).toArray();
        while (true) {

            int e = 0, day = 0;
            boolean[][] visited = new boolean[MAP.length][MAP.length];
            for (int i = 0; i < MAP.length; i++) for (int j = 0; j < MAP.length; j++)
                if (MAP[i][j] == WALL) visited[i][j] = true;
            Queue<int[]> q = Arrays.stream(actives)
                    .mapToObj(i -> VIRUSES.get(i - 1))
                    .peek(v -> visited[v[0]][v[1]] = true)
                    .collect(Collectors.toCollection(LinkedList::new));
            while (!q.isEmpty()) {

                day++;
                int size = q.size();
                while (size-- > 0) {
                    int[] v = q.poll();
                    int x = v[0], y = v[1];

                    for (int i = 0; i < 4; i++) {
                        int nx = x + DX[i], ny = y + DY[i];
                        if (nx < 0 || nx >= MAP.length || ny < 0 || ny >= MAP.length || visited[nx][ny]) continue;
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        if (MAP[nx][ny] == EMPTY) e++;
                    }
                }

                if (e == E) {
                    min = Math.min(min, day);
                    break;
                }
            }

            OptionalInt rm = IntStream.iterate(M - 1, i -> i >= 0, i -> i - 1)
                    .dropWhile(i -> actives[i] == VIRUSES.size() - M + i + 1)
                    .findFirst();
            if (rm.isEmpty()) break;

            int i = rm.getAsInt();
            actives[i]++;
            for (int j = i + 1; j < M; j++) actives[j] = actives[j - 1] + 1;
        }
        return String.valueOf(min == Integer.MAX_VALUE ? -1 : min);
    }

}

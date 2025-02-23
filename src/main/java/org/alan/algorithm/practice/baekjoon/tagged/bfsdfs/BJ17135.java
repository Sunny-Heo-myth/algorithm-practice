package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.*;
import java.util.stream.Stream;

public class BJ17135 {
    private final int[] dx = {0, -1, 0}, dy = {-1, 0, 1};
    private int M, N, D;
    private boolean[][] map;

    public String solve(String input) {
        String[] lines = input.split("\n");
        int[] fl = Arrays.stream(lines[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        M = fl[0]; N = fl[1]; D = fl[2];
        boolean[][] original = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String[] line = lines[i + 1].split(" ");
            for (int j = 0; j < N; j++) original[i][j] = line[j].equals("1");
        }

        int max = 0;
        for (int a = 0; a < N; a++) for (int b = a + 1; b < N; b++) for (int c = b + 1; c < N; c++) {
            map = new boolean[M][N];
            for (int i = 0; i < M; i++) System.arraycopy(original[i], 0, map[i], 0, N);

            int cMax = 0;
            for (int time = 0; time < M; time++) {
                for (int[] t : Stream.of(chooseTarget(a), chooseTarget(b), chooseTarget(c)).toArray(int[][]::new)) {
                    if (t[0] == -1 || !map[t[0]][t[1]]) continue;
                    map[t[0]][t[1]] = false;
                    cMax++;
                }

                List<int[]> next = new ArrayList<>();
                for (int i = 0; i < M - 1; i++) for (int j = 0; j < N; j++) if (map[i][j]) next.add(new int[]{i, j});
                if (next.isEmpty()) break;
                map = new boolean[M][N];
                next.forEach(t -> map[t[0] + 1][t[1]] = true);
            }
            max = Math.max(max, cMax);
        }
        return String.valueOf(max);
    }

    private int[] chooseTarget(int n) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{M - 1, n, 1});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0], y = poll[1], d = poll[2];
            if (d > D) break;
            if (map[x][y]) return poll;

            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                q.offer(new int[]{nx, ny, d + 1});
            }
        }
        return new int[] {-1, -1};
    }

}

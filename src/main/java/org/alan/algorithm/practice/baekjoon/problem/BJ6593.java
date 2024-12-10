package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class BJ6593 {
    public String solve(String input) {
        char START = 'S', END = 'E', WALL = '#';
        int[] dx = {1, -1, 0, 0, 0, 0}, dy = {0, 0, 1, -1, 0, 0}, dz = {0, 0, 0, 0, 1, -1};
        char [][][] cube = Pattern.compile("\n\n").splitAsStream(input.substring(input.indexOf("\n") + 1))
                .map(matrix -> Pattern.compile("\n").splitAsStream(matrix)
                        .map(String::toCharArray)
                        .toArray(char[][]::new))
                .toArray(char[][][]::new);
        int xLen = cube.length, yLen = cube[0].length, zLen = cube[0][0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < xLen; i++) for (int j = 0; j < yLen; j++) for (int k = 0; k < zLen; k++) {
            if (cube[i][j][k] != START) continue;
            queue.offer(new int[]{i, j, k, 0});
            break;
        }

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int x = polled[0], y = polled[1], z = polled[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i], ny = y + dy[i], nz = z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= xLen || ny >= yLen ||nz >= zLen) continue;
                if (cube[nx][ny][nz] == END) return "Escaped in " + (polled[3] + 1) + " minute(s).";

                if (cube[nx][ny][nz] != '.') continue;
                cube[nx][ny][nz] = START;
                queue.offer(new int[]{nx, ny, nz, polled[3] + 1});
            }
        }
        return "Trapped!";
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7562 {
    private final int[][] memo;
    private final int[] start, destination;
    private static final int[] DX = {-2, -2, -1, -1, 1, 1, 2, 2}, DY = {1, -1, 2, -2, 2, -2, 1, -1};

    public BJ7562(String input) {
        String[] lines = input.split("\n");
        int length = Integer.parseInt(lines[0]);
        memo = new int[length][length];
        start = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        destination = Arrays.stream(lines[2].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public String solve() {
        if (Arrays.equals(start, destination)) return "0";
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        memo[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], count = memo[x][y];

            if (Arrays.equals(poll, destination)) {
                return String.valueOf(count);
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + DX[i], ny = y + DY[i];
                if (nx < 0 || nx >= memo.length || ny < 0 || ny >= memo.length || memo[nx][ny] != 0) continue;

                queue.offer(new int[]{nx, ny});
                memo[nx][ny] = count + 1;
            }
        }
        return "-1";
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.bt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ19236 {
    private final int[]
            dx = {-1, -1, 0, 1, 1, 1, 0, -1},
            dy = {0, -1, -1, -1, 0, 1, 1, 1};
    private int max = 0;

    public String solve(String input) {
        int[][] init = new int[4][4];
        int[] dirs = new int[17];
        int[][] temp = input.lines().map(s ->
                Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        for (int i = 0; i < 4; i++) for (int j = 0; j < 4; j++) init[i][j] = temp[i][j * 2];
        for (int i = 0; i < 4; i++) for (int j = 0; j < 4; j++) dirs[temp[i][j * 2]] = temp[i][j * 2 + 1] - 1;

        int eaten = init[0][0], dir = dirs[eaten];

        init[0][0] = 0;
        dirs[eaten] = -1;
        recur(init, dirs, 0, 0, dir, eaten);

        return String.valueOf(max);
    }

    private void recur(int[][] now, int[] dirs, int sx, int sy, int sdir, int sum) {
        int[][] next = new int[4][4];
        int[] nDirs = new int[17];
        int[][] temp = new int[17][2];
        for (int i = 0; i < 4; i++) System.arraycopy(now[i], 0, next[i], 0, 4);
        System.arraycopy(dirs, 0, nDirs, 0, 17);
        for (int i = 0; i < 4; i++) for (int j = 0; j < 4; j++) if (next[i][j] != 0) temp[next[i][j]] = new int[]{i, j};

        for (int f = 1; f <= 16; f++) if (nDirs[f] != -1) {
            int[] fish = temp[f];
            int x1 = fish[0], y1 = fish[1];
            for (int d = nDirs[f]; d < nDirs[f] + 8; d++) {
                int ed = d % 8, x2 = x1 + dx[ed], y2 = y1 + dy[ed];
                if (x2 < 0 || x2 >= 4 || y2 < 0 || y2 >= 4 || (x2 == sx && y2 == sy)) continue;
                int fish1 = next[x1][y1], fish2 = next[x2][y2];
                int[] l1 = temp[fish1], l2 = temp[fish2];

                next[x1][y1] = fish2;
                next[x2][y2] = fish1;
                nDirs[fish1] = ed;
                temp[fish1] = l2;
                temp[fish2] = l1;
                break;
            }
        }

        List<int[]> edibleFish = IntStream.range(1, 4)
                .mapToObj(i -> new int[]{sx + dx[sdir] * i, sy + dy[sdir] * i})
                .takeWhile(xy -> xy[0] >= 0 && xy[0] < 4 && xy[1] >= 0 && xy[1] < 4)
                .filter(xy -> next[xy[0]][xy[1]] != 0)
                .collect(Collectors.toList());

        if (edibleFish.isEmpty()) max = Math.max(max, sum);
        else for (int[] xy : edibleFish) {
            int x = xy[0], y = xy[1], eaten = next[x][y], nDir = nDirs[eaten];

            next[x][y] = 0;
            nDirs[eaten] = -1;
            recur(next, nDirs, x, y, nDir, eaten + sum);
            next[x][y] = eaten;
            nDirs[eaten] = nDir;
        }
    }

}

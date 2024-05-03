package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ1743 {

    public String solve(String input) {
        int[] dx = {1, 0 ,-1, 0};
        int[] dy = {0 ,-1, 0, 1};
        int[] firstLine = Pattern.compile(" ").splitAsStream(input.split("\n")[0] )
                .mapToInt(Integer::parseInt).toArray();
        Boolean[][] map = new Boolean[firstLine[0]][firstLine[1]];

        input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .forEach(cd -> map[cd[0] - 1][cd[1] - 1] = true);

        int max = 0;
        for (int i = 0; i < firstLine[0]; i++) for (int j = 0; j < firstLine[1]; j++) {
            if (map[i][j] == null) continue;
            Stack<int[]> stack = new Stack<>();
            int currentMax = 0;

            map[i][j] = null;  // lead
            stack.push(new int[]{i, j});
            currentMax++;

            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                for (int k = 0; k < 4; k++) {
                    int nx = pop[0] + dx[k]; int ny = pop[1] + dy[k];
                    if (nx < 0 || nx >= firstLine[0] || ny < 0 || ny >= firstLine[1] || map[nx][ny] == null) continue;

                    map[nx][ny] = null;    // st
                    stack.push(new int[]{nx, ny});
                    currentMax++;
                }
            }

            max = Math.max(max, currentMax);
        }

        return String.valueOf(max);
    }
}

package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ14503 {
    public String solve(String input) {
        int[] dx = {-1, 0, 1, 0}; int[] dy = {0, 1, 0, -1};
        Boolean[][] map = input.lines().skip(2).map(s -> Pattern.compile(" ").splitAsStream(s).map(ss ->
                ss.equals("1") ? null : Boolean.FALSE).toArray(Boolean[]::new)).toArray(Boolean[][]::new);
        Stack<int[]> stack = new Stack<>();

        int answer = 0;
        stack.push(Pattern.compile(" ").splitAsStream(input.split("\n")[1]).mapToInt(Integer::parseInt).toArray());

        loop: while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int x = pop[0]; int y = pop[1]; int d = pop[2];
            if (map[x][y] == Boolean.FALSE) {
                map[x][y] = Boolean.TRUE; answer++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; int ny = y + dy[i];
                if (cantGo(map, nx, ny) || map[nx][ny] != Boolean.FALSE) continue;
                int nd = (d + 3) % 4;
                nx = x + dx[nd]; ny = y + dy[nd];
                if (cantGo(map, nx, ny) || map[nx][ny] == Boolean.FALSE) stack.push(new int[]{nx, ny, nd});
                else stack.push(new int[]{x, y, nd});
                continue loop;
            }

            int nd = (d + 2) % 4;
            int nx = x + dx[nd]; int ny = y + dy[nd];
            if (cantGo(map, nx, ny) || map[nx][ny] == null) break;
            stack.push(new int[]{nx, ny, d});
        }
        return String.valueOf(answer);
    }

    private boolean cantGo(Boolean[][] map, int nx, int ny) {
        return nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length;
    }
}

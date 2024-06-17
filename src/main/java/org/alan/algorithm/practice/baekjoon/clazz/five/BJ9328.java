package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ9328 {
    public String solve(String input) {
        String[] firstLine = input.split("\n")[0].split(" ");
        int h = Integer.parseInt(firstLine[0]); int w = Integer.parseInt(firstLine[1]); int m = h + 2; int n = w + 2;
        int[] dx = {1, 0, -1, 0}; int[] dy = {0, 1, 0, -1};

        String rim = ".".repeat(w + 2);
        String mid = input.lines().skip(1).limit(h).map(s -> ("." + s + ".")).collect(Collectors.joining("\n"));
        int[][] map = (rim + "\n" + mid + "\n" + rim).lines().map(s -> s.chars().toArray()).toArray(int[][]::new);
        boolean[][] visited = new boolean[m][n];

        boolean[] keys = new boolean[26];
        input.lines().skip(1 + h).flatMapToInt(String::chars).filter(i -> i != '0').forEach(i -> keys[i - 'a'] = true);

        int answer = 0;
        Stack<int[]> stack = new Stack<>();
        List<Stack<int[]>> knocked = new ArrayList<>(); IntStream.range(0, 26).forEach(i -> knocked.add(new Stack<>()));

        stack.push(new int[]{0, 0});
        visited[0][0] = true;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop(); int x = pop[0], y = pop[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || map[nx][ny] == '*') continue;
                int t = map[nx][ny];

                if (t != '.') {
                    if (t == '$') answer++;
                    else if (t >= 'A' && t <= 'Z' && !keys[t - 'A']) {
                        knocked.get(t - 'A').push(new int[]{nx, ny});
                        continue;
                    } else if (t >= 'a' && t <= 'z') {
                        keys[t - 'a'] = true;
                        while (!knocked.get(t - 'a').isEmpty()) {
                            int[] door = knocked.get(t - 'a').pop();
                            stack.push(new int[]{door[0], door[1]});
                            visited[door[0]][door[1]] = true;
                        }
                    }
                    map[nx][ny] = '.';
                }

                stack.push(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return String.valueOf(answer);
    }
}

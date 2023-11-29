package org.alan.algorithm.practice.baekjoon.level.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BJ2667 {
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        List<int[]> ints = new ArrayList<>();

        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = s[i + 1].toCharArray();
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') {
                    map[i][j] = true;
                    ints.add(new int[]{i, j});
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int[] i : ints) {
            if (!map[i[0]][i[1]]) continue;
            Stack<int[]> stack = new Stack<>();

            stack.push(i);
            map[i[0]][i[1]] = false;

            int count = 0;
            while (!stack.isEmpty()) {
                int[] now = stack.pop();
                int nowX = now[0];
                int nowY = now[1];

                count++;

                for (int j = 0; j < 4; j++) {
                    int nextX = nowX + DX[j];
                    int nextY = nowY + DY[j];
                    if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n && map[nextX][nextY]) {
                        stack.push(new int[]{nextX, nextY});
                        map[nextX][nextY] = false;
                    }
                }
            }
            answer.add(count);
        }
        return answer.size() + "\n" + answer.stream().sorted().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}

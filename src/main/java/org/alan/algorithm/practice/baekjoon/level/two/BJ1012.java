package org.alan.algorithm.practice.baekjoon.level.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1012 {
    private static final int[] XX = {1, 0, -1, 0};
    private static final int[] YY = {0, 1, 0, -1};
    private boolean[][] map;
    private int[][] cabbages;
    private Stack<int[]> stack;

    public String solve() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberOfQuestions = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while (numberOfQuestions > 0) {
            String[] s = bf.readLine().split(" ");
            int height = Integer.parseInt(s[1]);
            int width = Integer.parseInt(s[0]);
            map = new boolean[height][width];

            int bugNumber = Integer.parseInt(s[2]);
            cabbages = new int[bugNumber][2];

            for (int i = 0; i < bugNumber; i++) {
                String[] ss = bf.readLine().split(" ");
                int x = Integer.parseInt(ss[1]);
                int y = Integer.parseInt(ss[0]);

                map[x][y] = true;
                cabbages[i][0] = x;
                cabbages[i][1] = y;
            }

            sb.append(answer()).append("\n");
            numberOfQuestions--;
        }
        
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private int answer() {
        int count = 0;
        stack = new Stack<>();

        for (int[] cabbage : cabbages) {
            if (check(cabbage)) {
                stack.push(cabbage);
                traverse();
                count++;
            }
        }

        return count;
    }

    private void traverse() {
        while (!stack.isEmpty()) {
            int[] cabbage = stack.pop();

            for (int i = 0; i < 4; i++) {
                int xx = cabbage[0] + XX[i];
                int yy = cabbage[1] + YY[i];
                int[] next = {xx, yy};

                if (xx >= 0 && xx < map.length
                        && yy >= 0 && yy < map[0].length
                        && check(next)) {
                    map[xx][yy] = false;
                    stack.push(next);
                }
            }
        }
    }

    private boolean check(int[] coordinate) {
        return map[coordinate[0]][coordinate[1]];
    }

}

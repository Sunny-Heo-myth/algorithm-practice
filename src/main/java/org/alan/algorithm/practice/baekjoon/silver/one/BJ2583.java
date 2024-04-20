package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ2583 {
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, -1, 0, 1};

    public String solve(String input) {
        String[] firstLine = input.split("\n")[0].split(" ");
        int N = Integer.parseInt(firstLine[0]); int M = Integer.parseInt(firstLine[1]);
        boolean[][] board = new boolean[M][N];
        input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .forEach(I -> { for (int i = I[0]; i < I[2]; i++) for (int j = I[1]; j < I[3]; j++) board[i][j] = true; });

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) for (int j = 0; j < N; j++) {
            if (board[i][j]) continue;

            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{i, j}); board[i][j] = true; int size = 1;

            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                int x = pop[0]; int y = pop[1];

                for (int k = 0; k < 4; k++) {
                    int xx = x + dx[k]; int yy = y + dy[k];
                    if (xx < 0 || xx >= M || yy < 0 || yy >= N || board[xx][yy]) continue;

                    stack.push(new int[]{xx, yy}); board[xx][yy] = true; size++;
                }
            }

            answer.add(size);
        }

        return answer.size() + "\n" + answer.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
    }
}

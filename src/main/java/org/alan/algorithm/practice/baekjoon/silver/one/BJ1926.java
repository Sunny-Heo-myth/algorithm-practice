package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Stack;
import java.util.regex.Pattern;

public class BJ1926 {
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, -1, 0, 1};

    public String solve(String input) {
        Boolean[][] board = input.lines().skip(1).map(s ->
                        Pattern.compile(" ").splitAsStream(s).map(ss -> ss.equals("1") ? Boolean.TRUE : Boolean.FALSE)
                                .toArray(Boolean[]::new)).toArray(Boolean[][]::new);

        int numberOfPicture = 0;
        int biggest = 0;
        for (int i = 0; i < board.length; i++) for (int j = 0; j < board[0].length; j++) {
            if (!board[i][j]) continue;

            numberOfPicture++;  // st
            Stack<int[]> stack = new Stack<>();
            int currentSize = 0;

            stack.push(new int[]{i, j});    // st
            board[i][j] = false;  // st
            currentSize++;  // st

            while (!stack.isEmpty()) {
                int[] now = stack.pop(); // st
                for (int k = 0; k < 4; k++) {
                    int x = now[0] + dx[k]; int y = now[1] + dy[k];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || !board[x][y]) continue;

                    stack.push(new int[]{x, y}); // st
                    board[x][y] = false;  // st
                    currentSize++;  // st
                }
            }

            biggest = Math.max(biggest, currentSize);
        }
        return numberOfPicture + "\n" + biggest;
    }
}

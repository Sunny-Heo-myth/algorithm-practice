package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Sudoku
 */
public class BJ2239 {
    private int[][] board;
    private final List<int[]> blankList = new ArrayList<>();
    private boolean finished = false;
    private String answer;

    public String solve(String input) {
        board = input.lines().map(s -> s.chars().map(i -> i - 48).toArray()).toArray(int[][]::new);
        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) if (board[i][j] == 0) blankList.add(new int[]{i, j});
        startFrom(0);
        return answer;
    }

    private void startFrom(int blankListIdx) {
        if (finished) return;

        if (blankListIdx == blankList.size()) {
            answer = Arrays.stream(board).map(intArray ->
                            Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining("")))
                    .collect(Collectors.joining("\n"));
            finished = true;
            return;
        }

        int[] blank = blankList.get(blankListIdx);
        int x = blank[0];
        int y = blank[1];
        for (int n = 1; n <= 9; n++) {
            if (isColumnRepeated(y, n) || isRowRepeated(x, n) || isBoxRepeated(x, y ,n)) continue;
            board[x][y] = n;
            startFrom(blankListIdx + 1);
            board[x][y] = 0;
        }
    }

    private boolean isColumnRepeated(int y, int n) {
        return IntStream.range(0, 9).anyMatch(x -> board[x][y] == n);
    }

    private boolean isRowRepeated(int x, int n) {
        return IntStream.range(0, 9).anyMatch(y -> board[x][y] == n);
    }

    private boolean isBoxRepeated(int x, int y, int n) {
        int fromX = (x / 3) * 3;
        int fromY = (y / 3) * 3;
        for (int i = fromX; i < fromX + 3; i++) for (int j = fromY; j < fromY + 3; j++) if (board[i][j] == n) return true;
        return false;
    }
}

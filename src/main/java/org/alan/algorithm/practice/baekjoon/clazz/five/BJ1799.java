package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * How many bishop would be able to put on this chessboard where each can not catch any other.
 * input n * n (natural number, maximum 10) chessboard where 1 or 0 referring the availability to land a bishop.
 * answer: maximum number of bishop that this board can hold.
 */
public class BJ1799 {
    private boolean[][] notAvailable;
    private int[][] board;
    private List<int[]> landAbleList; // stateless
    private int count = 0;

    public String solve(String input) {
        board = input.lines().skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        notAvailable = new boolean[board.length][board.length];
        int sum = 0;

        landAbleList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            int j = i % 2 == 0 ? 0 : 1;
            while (j < board.length) {
                if (board[i][j] == 0) notAvailable[i][j] = true;
                else landAbleList.add(new int[]{i, j});
                j += 2;
            }
        }
        backtracking(0, 0);

        sum += count;
        count = 0;

        landAbleList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            int j = i % 2 != 0 ? 0 : 1;
            while (j < board.length) {
                if (board[i][j] == 0) notAvailable[i][j] = true;
                else landAbleList.add(new int[]{i, j});
                j += 2;
            }
        }
        backtracking(0, 0);

        return String.valueOf(sum + count);
    }

    private void backtracking(int landAbleIndex, int currentCount) {
        while (landAbleIndex < landAbleList.size()) {

            int[] now = landAbleList.get(landAbleIndex++);
            int x = now[0]; int y = now[1];
            if (notAvailable[x][y] || board[x][y] <= 0) continue;

            notAvailable[x][y] = true;
            mark(x, y, -1);
            backtracking(landAbleIndex, currentCount + 1);
            notAvailable[x][y] = false;
            mark(x, y, 1);
        }

        count = Math.max(currentCount, count);
    }

    private void mark(int x, int y, int increment) {
        board[x][y] += increment;

        int n1 = x - 1;
        int m1 = y - 1;
        while (n1 >= 0 && m1 >= 0) {
            if (!notAvailable[n1][m1]) board[n1][m1] += increment;
            n1--; m1--;
        }

        int n2 = x - 1;
        int m2 = y + 1;
        while (n2 >= 0 && m2 < board.length) {
            if (!notAvailable[n2][m2]) board[n2][m2] += increment;
            n2--; m2++;
        }

        int n3 = x + 1;
        int m3 = y - 1;
        while (n3 < board.length && m3 >= 0) {
            if (!notAvailable[n3][m3]) board[n3][m3] += increment;
            n3++; m3--;
        }

        int n4 = x + 1;
        int m4 = y + 1;
        while (n4 < board.length && m4 < board.length) {
            if (!notAvailable[n4][m4]) board[n4][m4] += increment;
            n4++; m4++;
        }
    }

}

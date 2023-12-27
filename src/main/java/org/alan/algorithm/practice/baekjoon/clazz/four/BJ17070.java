package org.alan.algorithm.practice.baekjoon.clazz.four;

public class BJ17070 {
    private int n;
    private boolean[][] blocked;
    private int answer = 0;

    public String solve(String input) {
        String[] lines = input.split("\n");
        n = Integer.parseInt(lines[0]);

        blocked = new boolean[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            String[] ss = lines[i].split(" ");
            for (int j = 1; j < n + 1; j++) blocked[i][j] = ss[j - 1].equals("1");
        }
        blocked[1][1] = blocked[1][2] = true;

        step(1, 2, Shape.HORIZONTAL);

        return String.valueOf(answer);
    }

    private void step(int x, int y, Shape shape) {
        if (x == n && y == n) {
            answer++;
            return;
        }

        switch (shape) {
            case HORIZONTAL:
                tryHorizontal(x, y);
                tryDiagonal(x, y);
                break;
            case DIAGONAL:
                tryVertical(x, y);
                tryDiagonal(x, y);
                tryHorizontal(x, y);
                break;
            case VERTICAL:
                tryVertical(x, y);
                tryDiagonal(x, y);
                break;
        }
    }

    private void tryVertical(int x, int y) {
        if (isWithIn(x + 1, y) && !blocked[x + 1][y]) {
            blocked[x][y] = true;
            step(x + 1, y, Shape.VERTICAL);
            blocked[x + 1][y] = false;
        }
    }

    private void tryDiagonal(int x, int y) {
        if (isWithIn(x + 1, y + 1) && !blocked[x][y + 1] && !blocked[x + 1][y + 1] && !blocked[x + 1][y]) {
            blocked[x][y + 1] = true;
            blocked[x + 1][y + 1] = true;
            blocked[x + 1][y] = true;
            step(x + 1, y + 1, Shape.DIAGONAL);
            blocked[x][y + 1] = false;
            blocked[x + 1][y + 1] = false;
            blocked[x + 1][y] = false;
        }
    }

    private void tryHorizontal(int x, int y) {
        if (isWithIn(x, y + 1) && !blocked[x][y + 1]) {
            blocked[x][y + 1] = true;
            step(x, y + 1, Shape.HORIZONTAL);
            blocked[x][y + 1] = false;
        }
    }

    private boolean isWithIn(int x, int y) {
        return x <= n && y <= n;
    }

    private enum Shape {
        HORIZONTAL, DIAGONAL, VERTICAL
    }
}

package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class BJ12100 {
    private int N;

    public String solve(String input) {
        N = Integer.parseInt(input.split("\n")[0]);
        int[][] board = input.lines().skip(1).map(s -> Pattern.compile(" ")
                .splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        Stack<Box> stack = new Stack<>();

        int max = getMax(board);
        stack.push(new Box(board, 0));

        while (!stack.isEmpty()) {
            Box pop = stack.pop();
            if (pop.times >= 5) continue;
            int[][] popped = pop.content;

            int[][] up = moveUp(popped);
            max = Math.max(max, getMax(up));
            stack.push(new Box(up, pop.times + 1));
            int[][] down = moveDown(popped);
            max = Math.max(max, getMax(down));
            stack.push(new Box(down, pop.times + 1));
            int[][] left = moveLeft(popped);
            max = Math.max(max, getMax(left));
            stack.push(new Box(left, pop.times + 1));
            int[][] right = moveRight(popped);
            max = Math.max(max, getMax(right));
            stack.push(new Box(right, pop.times + 1));
        }

        return String.valueOf(max);
    }

    private int getMax(int[][] board) {
        return Arrays.stream(board).mapToInt(ints -> Arrays.stream(ints).max().orElse(-1)).max().orElse(-1);
    }

    private int[][] moveUp(int[][] in) {
        int[][] out = new int[N][N];
        for (int column = 0; column < N; column++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = N - 1; i >= 0; i--) stack.push(in[i][column]);

            int t = 0;
            while (!stack.isEmpty()) {
                int popped = stack.pop();
                if (popped == 0) continue;
                boolean written = false;

                while (!stack.isEmpty()) {
                    if (stack.peek() == 0) stack.pop();
                    else {
                        if (stack.peek() == popped) out[t++][column] = stack.pop() * 2;
                        else out[t++][column] = popped;
                        written = true;
                        break;
                    }
                }
                if (!written) out[t][column] = popped;
            }
        }
        return out;
    }

    private int[][] moveDown(int[][] in) {
        int[][] out = new int[N][N];
        for (int column = 0; column < N; column++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) stack.push(in[i][column]);

            int t = N - 1;
            while (!stack.isEmpty()) {
                int popped = stack.pop();
                if (popped == 0) continue;
                boolean written = false;

                while (!stack.isEmpty()) {
                    if (stack.peek() == 0) stack.pop();
                    else {
                        if (stack.peek() == popped) out[t--][column] = stack.pop() * 2;
                        else out[t--][column] = popped;
                        written = true;
                        break;
                    }
                }
                if (!written) out[t][column] = popped;
            }
        }
        return out;
    }

    private int[][] moveLeft(int[][] in) {
        int[][] out = new int[N][N];
        for (int row = 0; row < N; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = N - 1; i >= 0; i--) stack.push(in[row][i]);

            int t = 0;
            while (!stack.isEmpty()) {
                int popped = stack.pop();
                if (popped == 0) continue;
                boolean written = false;

                while (!stack.isEmpty()) {
                    if (stack.peek() == 0) stack.pop();
                    else {
                        if (stack.peek() == popped) out[row][t++] = stack.pop() * 2;
                        else out[row][t++] = popped;
                        written = true;
                        break;
                    }
                }
                if (!written) out[row][t] = popped;
            }
        }
        return out;
    }

    private int[][] moveRight(int[][] in) {
        int[][] out = new int[N][N];
        for (int row = 0; row < N; row++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) stack.push(in[row][i]);

            int t = N - 1;
            while (!stack.isEmpty()) {
                int popped = stack.pop();
                if (popped == 0) continue;
                boolean written = false;

                while (!stack.isEmpty()) {
                    if (stack.peek() == 0) stack.pop();
                    else {
                        if (stack.peek() == popped) out[row][t--] = stack.pop() * 2;
                        else out[row][t--] = popped;
                        written = true;
                        break;
                    }
                }
                if (!written) out[row][t] = popped;
            }
        }
        return out;
    }
}

class Box {
    int[][] content;
    int times;

    public Box(int[][] content, int times) {
        this.content = content;
        this.times = times;
    }
}
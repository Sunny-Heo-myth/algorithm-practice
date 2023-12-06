package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ2206 {
    private static final int[] toX = {1, 0, -1, 0};
    private static final int[] toY = {0, 1, 0, -1};
    private int rowLength;
    private int columnLength;
    private Integer[][] map;
    private final Stack<int[]> stack = new Stack<>();
    private boolean flag = false;

    public String solve(String input) {
        String[] firstLine = input.split("\n")[0].split(" ");
        rowLength = Integer.parseInt(firstLine[0]);
        columnLength = Integer.parseInt(firstLine[1]);
        if (rowLength == 1 && columnLength == 1) return String.valueOf(1);

        map = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(s -> IntStream.range(0, columnLength).boxed()
                        .map(i -> s.charAt(i) == '1' ? null : 0).toArray(Integer[]::new))
                .toArray(Integer[][]::new);

        stack.push(new int[]{0, 0});
        while (!stack.isEmpty()) traverse(stack.pop());

        int result = map[rowLength - 1][columnLength - 1] + 1;
        return String.valueOf(result == 1 ? -1 : result);
    }

    private void traverse(int[] a) {
        for (int i = 0; i < 4; i++) {
            int fromX = a[0];
            int fromY = a[1];
            int toX = fromX + BJ2206.toX[i];
            int toY = fromY + BJ2206.toY[i];
            if (toX < 0 && toX >= rowLength && toY < 0 && toY >= columnLength) continue;

            if (map[toX][toY] != null) {
                if (map[toX][toY] == 0 || map[fromX][fromY] + 1 < map[toX][toY]) {
                    map[toX][toY] = map[fromX][fromY] + 1;
                    stack.push(new int[]{toX, toY});
                }
            } else if (!flag) {
                flag = true;
                map[toX][toY] = 0;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 1 && M == 1) {
            System.out.print(1);
            System.exit(0);
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        boolean[][] map = new boolean[N][M];
        int[][] distance = new int[N][M];
        boolean[][][] visit = new boolean[2][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            for (int j = 0; j < M; j++) map[i][j] = s.charAt(j) != '1';
        }

        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] from = queue.poll();

            for (int i = 0; i < 4; i++) {
                int toX = from[0] + dx[i];
                int toY = from[1] + dy[i];
                if (toX < 0 || toX >= N || toY < 0 || toY >= M) continue;

                if (!map[toX][toY]) {   // if there is wall
                    // if the wall was never been broken && if the broken wall was never visited
                    if (from[2] == 0 && !visit[1][toX][toY]) {
                        visit[from[2]][toX][toY] = true;
                        distance[toX][toY] = distance[from[0]][from[1]] + 1;
                        queue.offer(new int[]{toX, toY, 1});
                    }

                } else if (!visit[from[2]][toX][toY]) {   // if there is no wall & if not visited
                    visit[from[2]][toX][toY] = true;
                    distance[toX][toY] = distance[from[0]][from[1]] + 1;
                    queue.offer(new int[]{toX, toY, from[2]});
                }

                if (toX == N - 1 && toY == M - 1) { // when arrive
                    System.out.print(distance[toX][toY] + 1);
                    System.exit(0);
                }
            }
        }
        System.out.print(-1);   // if we can't go further
    }

}

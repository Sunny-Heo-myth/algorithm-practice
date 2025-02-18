package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.Arrays;
import java.util.Stack;

public class BJ3109 {
    public String solve(String input) {
        int[] moves = {-1, 0, 1};

        int count = 0;
        char[][] map = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        for (int start = 0; start < map.length; start++) {
            Stack<int[]> stack = new Stack<>();

            map[start][0] = 'x';
            stack.push(new int[]{start, 0});
            while (!stack.isEmpty()) {
                int[] peek = stack.peek();
                int x = peek[0], y = peek[1];
                if (y == map[0].length - 1) {
                    count++;
                    break;
                }

                Arrays.stream(moves)
                        .mapToObj(move -> new int[]{x + move, y + 1})
                        .filter(xy -> xy[0] >= 0 && xy[0] < map.length && map[xy[0]][xy[1]] == '.')
                        .findFirst()
                        .ifPresentOrElse(xy -> {
                            map[xy[0]][xy[1]] = 'x';
                            stack.push(xy);
                        }, stack::pop);

//                boolean isProceeded = false;
//                for (int move : moves) {
//                    int nx = x + move, ny = y + 1;
//                    if (nx < 0 || nx >= map.length || map[nx][ny] != '.') continue;
//                    map[nx][ny] = 'x';
//                    stack.push(new int[]{nx, ny});
//                    isProceeded = true;
//                    break;
//                }
//                if (!isProceeded) stack.pop();
            }
        }
        return String.valueOf(count);
    }
}

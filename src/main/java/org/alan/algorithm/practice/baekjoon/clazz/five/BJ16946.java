package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ16946 {
    public String solve(String input) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int[] firstLine = input.lines().findFirst().stream().flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt)).toArray();
        int[][] map = input.lines().skip(1).map(s -> s.chars().map(ch -> ch - '0').toArray()).toArray(int[][]::new);
        int n = firstLine[0], m = firstLine[1], segment = 1000;

        Map<Integer, Integer> sizeMap = new HashMap<>();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (map[i][j] == 0) {
            Stack<int[]> stack = new Stack<>();

            int count = 1;
            map[i][j] = segment;
            stack.push(new int[]{i, j});
            while (!stack.isEmpty()) {
                int[] popped = stack.pop();
                for (int k = 0; k < 4; k++) {
                    int nx = popped[0] + dx[k], ny = popped[1] + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] != 0) continue;
                    count++;
                    map[nx][ny] = segment;
                    stack.push(new int[]{nx, ny});
                }
            }
            sizeMap.put(segment++, count);
        }

        int[][] answer = new int[n][m];
        IntStream.range(0, n).forEach(i -> IntStream.range(0, m).filter(j -> map[i][j] == 1).forEach(j ->
                answer[i][j] = (IntStream.range(0, 4)
                        .mapToObj(k -> new int[]{i + dx[k], j + dy[k]})
                        .filter(xy -> xy[0] >= 0 && xy[0] < n && xy[1] >= 0 && xy[1] < m && map[xy[0]][xy[1]] != 1)
                        .mapToInt(xy -> map[xy[0]][xy[1]])
                        .distinct()
                        .map(sizeMap::get)
                        .sum() + 1) % 10));
        return Arrays.stream(answer).map(ints -> Arrays.stream(ints).mapToObj(String::valueOf)
                .collect(Collectors.joining())).collect(Collectors.joining("\n"));
    }
}

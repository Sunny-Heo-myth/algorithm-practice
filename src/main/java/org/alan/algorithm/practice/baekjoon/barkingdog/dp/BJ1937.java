package org.alan.algorithm.practice.baekjoon.barkingdog.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BJ1937 {
    public String solve(String input) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
        int[][] map = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        List<int[]> sorted = Stream.iterate(0, i -> i < map.length, i -> i + 1)
                .flatMap(i -> IntStream.range(0, map.length).mapToObj(j -> new int[]{i, j}))
                .sorted(Comparator.comparingInt(xy -> map[xy[0]][xy[1]]))
                .collect(Collectors.toList());

        int[][] memo = new int[map.length][map.length];
        for (int[] xy : sorted) {
            int x = xy[0], y = xy[1];
            if (memo[x][y] == 0) memo[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue;
                if (map[nx][ny] > map[x][y] && memo[nx][ny] < memo[x][y] + 1) memo[nx][ny] = memo[x][y] + 1;
            }
        }
        return String.valueOf(IntStream.range(0, map.length).map(i ->
                Arrays.stream(memo[i], 0, map.length).max().orElse(-1)).max().orElse(-1));
    }
}

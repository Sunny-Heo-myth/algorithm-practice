package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.*;
import java.util.stream.IntStream;

public class BJ17472 {
    private final int w, h;
    private final int[][] map, graph;
    private final int[] parents, dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public BJ17472(String input) {
        map = input.lines().skip(1).map(s ->
                Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        w = map.length; h = map[0].length;

        int p = 1;
        boolean[][] visited = new boolean[w][h];
        for (int i = 0; i < w; i++) for (int j = 0; j < h; j++) if (map[i][j] == 1 && !visited[i][j]) {
            p++;
            Stack<int[]> stack = new Stack<>();

            map[i][j] = p;
            visited[i][j] = true;
            stack.push(new int[]{i, j});
            while (!stack.isEmpty()) {
                int[] pop = stack.pop();
                int x = pop[0], y = pop[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k], ny = y + dy[k];
                    if (nx < 0 || nx >= w || ny < 0 || ny >= h || map[nx][ny] == 0 || visited[nx][ny]) continue;
                    map[nx][ny] = p;
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
        graph = new int[p + 1][p + 1];
        for (int[] row : graph) Arrays.fill(row, Integer.MAX_VALUE);
        parents = IntStream.range(0, p + 1).toArray();
    }

    public String solve() {
        for (int i = 0; i < w; i++) for (int j = 0; j < h; j++) if (map[i][j] != 0) for (int k = 0; k < 4; k++) {
            final int x = i, y = j, d = k;
            Optional<int[]> op = IntStream.range(1, 10)
                    .mapToObj(n -> new int[]{x + n * dx[d], y + n * dy[d]})
                    .takeWhile(xy -> xy[0] >= 0 && xy[0] < w && xy[1] >= 0 && xy[1] < h)
                    .filter(xy -> map[xy[0]][xy[1]] != 0)
                    .findFirst();
            if (op.isEmpty()) continue;

            int[] next = op.get();
            int nx = next[0], ny = next[1], one = map[x][y], another = map[nx][ny],
                    distance = Math.max(Math.abs(x - nx), Math.abs(y - ny));
            if (distance <= 2 || one == another) continue;

            graph[one][another] = Math.min(distance, graph[one][another]);
            graph[another][one] = Math.min(distance, graph[another][one]);
        }

        List<int[]> edges = new ArrayList<>();
        for (int i = 2; i < parents.length; i++) for (int j = i + 1; j < parents.length; j++)
            if (graph[i][j] != Integer.MAX_VALUE) edges.add(new int[]{i, j, graph[i][j]});
        edges.sort(Comparator.comparingInt(edge -> edge[2]));

        int count = 0, totalCost = 0;
        for (int[] edge : edges) {
            int p1 = find(edge[0]), p2 = find(edge[1]);
            if (p1 != p2) {
                parents[p1] = p2;
                totalCost += (edge[2] - 1);
                count++;
            }
        }
        if (count != parents.length - 3) return "-1";
        return String.valueOf(totalCost);
    }

    private int find(int child) {
        if (parents[child] == child) return child;
        return parents[child] = find(parents[child]);
    }

}

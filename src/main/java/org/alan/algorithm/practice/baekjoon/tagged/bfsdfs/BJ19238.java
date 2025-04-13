package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.*;

public class BJ19238 {
    private final int[][] map, from;
    private final Map<Integer, int[]> to = new HashMap<>();

    private Queue<int[]> queue;
    private boolean[][] visited;
    private int sx, sy, fuel, clientCount;

    private static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    private static final int WALL = Integer.MAX_VALUE;

    public BJ19238(String input) {
        int[][] n = input.lines().map(s ->
                Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        map = Arrays.stream(n).skip(1).limit(n[0][0]).toArray(int[][]::new);
        for (int i = 0; i < map.length; i++) for (int j = 0; j < map.length; j++) if (map[i][j] == 1) map[i][j] = WALL;
        from = new int[map.length][map.length];
        sx = n[n[0][0] + 1][0] - 1; sy = n[n[0][0] + 1][1] - 1; fuel = n[0][2]; clientCount = n[0][1];
        for (int i = 1; i < n[0][1] + 1; i++) {
            int[] l = n[i + n[0][0] + 1];
            from[l[0] - 1][l[1] - 1] = i;
            to.put(i, new int[]{l[2] - 1, l[3] - 1});
        }
    }

    public String solve() {
        loop: while (clientCount > 0) {
            PriorityQueue<int[]> candidates = new PriorityQueue<>(
                    (c1, c2) -> c1[0] == c2[0] ? c1[1] - c2[1] : c1[0] - c2[0]);
            queue = new LinkedList<>();
            visited = new boolean[map.length][map.length];

            int closest = Integer.MAX_VALUE;
            visited[sx][sy] = true;
            queue.offer(new int[]{sx, sy, fuel});
            while (!queue.isEmpty() && (fuel - queue.peek()[2]) <= closest) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1], remainingFuel = poll[2];
                if (from[x][y] != 0) {
                    candidates.offer(new int[]{x, y, remainingFuel});
                    closest = fuel - remainingFuel;
                    continue;
                }

                go(x, y, remainingFuel);
            }

            if (candidates.isEmpty()) return "-1";
            int[] client = candidates.poll(), dest = to.get(from[client[0]][client[1]]);
            candidates.clear();
            queue.clear();
            visited = new boolean[map.length][map.length];

            visited[client[0]][client[1]] = true;
            queue.offer(client);
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1], remainingFuel = poll[2];

                if (x == dest[0] && y == dest[1]) {
                    int moved = client[2] - remainingFuel;
                    sx = x; sy = y;
                    fuel = remainingFuel + moved * 2;
                    clientCount--;
                    from[client[0]][client[1]] = 0;
                    continue loop;
                }

                go(x, y, remainingFuel);
            }
            return "-1";
        }

        return String.valueOf(fuel);
    }

    private void go(int x, int y, int remainingFuel) {
        if (remainingFuel == 0) return;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length
                    || map[nx][ny] == WALL || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            queue.offer(new int[]{nx, ny, remainingFuel - 1});
        }
    }

}

package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import java.util.*;

public class BJ5719 {
    private final int[][] map;
    private final List<List<Integer>> route = new ArrayList<>();
    private final int start, end;

    public BJ5719(String input) {
        int[][] arr = input.lines().map(s ->
                Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        map = new int[arr[0][0]][arr[0][0]];
        for (int i = 0; i < map.length; i++) route.add(new ArrayList<>());
        start = arr[1][0]; end = arr[1][1];
        Arrays.stream(arr).skip(2).forEach(line -> map[line[0]][line[1]] = line[2]);
    }

    public String solve() {
        int[] shortest = dijkstra();

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[map.length];

        queue.offer(end);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[now]) continue;
            visited[now] = true;

            for (int prev : route.get(now)) {
                if (map[prev][now] != 0 && shortest[prev] + map[prev][now] == shortest[now]) map[prev][now] = 0;
                queue.offer(prev);
            }
        }

        int[] shortest2 = dijkstra();
        return String.valueOf(shortest2[end] == Integer.MAX_VALUE ? -1 : shortest2[end]);
    }

    private int[] dijkstra() {
        int[] shortest = new int[map.length];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(ints -> ints[1]));

        shortest[start] = 0;
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int from = poll[0], cost = poll[1];

            for (int to = 0; to < map.length; to++) if (map[from][to] != 0) {
                int sum = cost + map[from][to];
                if (sum == shortest[to]) route.get(to).add(from);
                else if (sum < shortest[to]) {
                    shortest[to] = sum;
                    pq.offer(new int[]{to, sum});
                    route.get(to).clear();
                    route.get(to).add(from);
                }
            }
        }
        return shortest;
    }

}

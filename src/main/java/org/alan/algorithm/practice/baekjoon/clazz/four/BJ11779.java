package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ11779 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int numberOfCities = Integer.parseInt(s[0]);
        int numberOfBuses = Integer.parseInt(s[1]);

        boolean[] visited = new boolean[numberOfCities + 1];
        int[] previousCity = new int[numberOfCities + 1];
        int[] shortest = new int[numberOfCities + 1];
        Arrays.fill(shortest, Integer.MAX_VALUE);

        Map<Integer, List<ToCost>> map = new HashMap<>();
        IntStream.range(1, numberOfCities + 1).forEach(i -> map.put(i, new ArrayList<>()));
        for (int i = 2; i < numberOfBuses + 2; i++) {
            String[] ss = s[i].split(" ");
            map.get(Integer.parseInt(ss[0])).add(new ToCost(Integer.parseInt(ss[1]), Integer.parseInt(ss[2])));
        }

        String[] lastLine = s[numberOfBuses + 2].split(" ");
        int start = Integer.parseInt(lastLine[0]);
        int end = Integer.parseInt(lastLine[1]);

        PriorityQueue<ToCost> pq = new PriorityQueue<>();
        pq.offer(new ToCost(start, 0));
        shortest[start] = 0;
        previousCity[start] = 0;

        while (!pq.isEmpty()) {
            ToCost now = pq.poll();
            visited[now.to] = true;

            for (ToCost next : map.get(now.to)) {
                if (visited[next.to]) continue;
                if (shortest[now.to] + next.cost < shortest[next.to]) {
                    shortest[next.to] = shortest[now.to] + next.cost;
                    pq.offer(new ToCost(next.to, shortest[next.to]));
                    previousCity[next.to] = now.to;
                }
            }
        }

        ArrayList<Integer> routeList = new ArrayList<>();
        int now = end;
        while (now != 0) {
            routeList.add(now);
            now = previousCity[now];
        }
        Collections.reverse(routeList);
        return shortest[end] + "\n" + routeList.size() + "\n" +
                routeList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static class ToCost implements Comparable<ToCost> {
        private final int to;
        private final int cost;

        public ToCost(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(ToCost o) {
            return this.cost - o.cost;
        }
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ10217 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int[] fl = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();
        int N = fl[0], M = fl[1], INVALID = Integer.MAX_VALUE / 2;

        List<List<SpaceTime>> fromTo = new ArrayList<>();
        for (int i = 0; i <= N; i++) fromTo.add(new ArrayList<>());
        Arrays.stream(lines).skip(2)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .forEach(eg -> fromTo.get(eg[0]).add(new SpaceTime(eg[1], eg[3], eg[2])));
        fromTo.forEach(Collections::sort);

        int[][] timeMemo = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) Arrays.fill(timeMemo[i], INVALID);
        PriorityQueue<SpaceTime> pq = new PriorityQueue<>();

        timeMemo[1][0] = 0;
        pq.offer(new SpaceTime(1, 0, 0));
        while (!pq.isEmpty()) {
            SpaceTime from = pq.poll();
            if (timeMemo[from.where][from.cost] < from.took) continue;

            for (SpaceTime to : fromTo.get(from.where)) {
                int nextCost = from.cost + to.cost, nextTook = from.took + to.took;
                if (nextCost > M || timeMemo[to.where][nextCost] <= nextTook) continue;

                timeMemo[to.where][nextCost] = nextTook;
                pq.offer(new SpaceTime(to.where, nextTook, nextCost));
            }
        }

        int answer = IntStream.rangeClosed(0, M).map(m -> timeMemo[N][m]).min().orElse(INVALID);
        return String.valueOf(answer == INVALID ? "Poor KCM" : answer);
    }

    private static class SpaceTime implements Comparable<SpaceTime> {
        int where, took, cost;

        public SpaceTime(int where, int took, int cost) {
            this.where = where;
            this.took = took;
            this.cost = cost;
        }

        @Override
        public int compareTo(SpaceTime o) {
            return this.took - o.took;
        }
    }

}

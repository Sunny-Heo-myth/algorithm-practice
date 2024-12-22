package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.Queue;

public class BJ17071 {

    public String solve(String input) {
        String[] s = input.split(" ");
        int subin = Integer.parseInt(s[0]), sis = Integer.parseInt(s[1]), MAX = 500000;

        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] subinVisited = new boolean[MAX + 1][2];

        queue.offer(subin);
        subinVisited[subin][0] = true;
        while (!queue.isEmpty()) {
            sis += time;
            if (sis > MAX) return "-1";
            if (subinVisited[sis][time % 2]) return String.valueOf(time);

            int size = queue.size();
            while (size-- > 0) {
                int position = queue.poll();
                int[] nextPositions = {position - 1, position + 1, position * 2};
                for (int next : nextPositions) {
                    if (next < 0 || next > MAX || subinVisited[next][(time + 1) % 2]) continue;
                    queue.offer(next);
                    subinVisited[next][(time + 1) % 2] = true;
                }
            }
            time++;
        }
        return "-1";
    }

}

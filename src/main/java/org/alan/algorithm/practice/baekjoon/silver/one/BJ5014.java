package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

public class BJ5014 {
    public String solve(String input) {
        int[] ints = Pattern.compile(" ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
        int F = ints[0]; int S = ints[1]; int G = ints[2]; int U = ints[3]; int D = ints[4];

        Queue<Integer> queue = new LinkedList<>();
        int[] shortest = new int[F + 1];

        queue.offer(S);    // st
        shortest[S] = 1;    // st

        while (!queue.isEmpty()) {
            int i = queue.poll();    // st

            if (i == G) return String.valueOf(shortest[i] - 1);

            int u = i + U;
            if (u <= F && shortest[u] == 0) {
                shortest[u] = shortest[i] + 1;    // st
                queue.offer(u);    // st
            }

            int d = i - D;
            if (d > 0 && shortest[d] == 0) {
                shortest[d] = shortest[i] + 1;    // st
                queue.offer(d);    // st
            }
        }

        return "use the stairs";
    }
}

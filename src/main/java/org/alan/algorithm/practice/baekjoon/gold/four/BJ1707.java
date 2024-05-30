package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1707 {

    public String solve(String input) {
        int V = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
        List<List<Integer>> incidence = IntStream.rangeClosed(0, V)
                .mapToObj(i -> new ArrayList<Integer>()).collect(Collectors.toUnmodifiableList());
        input.lines().skip(1).map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
                .forEach(ints -> { incidence.get(ints[0]).add(ints[1]); incidence.get(ints[1]).add(ints[0]); });
        int[] bipartite = new int[V + 1];

        for (int v = 1; v <= V; v++) if (bipartite[v] == 0) {
            Queue<int[]> queue = new LinkedList<>();

            bipartite[v] = 1;
            queue.add(new int[]{v, bipartite[v]});

            while (!queue.isEmpty()) {
                int[] polled = queue.poll();

                for (int nv : incidence.get(polled[0])) {
                    if (bipartite[nv] == 0) {
                        bipartite[nv] = polled[1] == 1 ? 2 : 1;
                        queue.add(new int[]{nv, bipartite[nv]});
                    } else if (bipartite[nv] == polled[1]) return "NO";
                }
            }
        }

        return "YES";
    }
}

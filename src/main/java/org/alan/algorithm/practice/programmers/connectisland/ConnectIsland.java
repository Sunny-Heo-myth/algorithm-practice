package org.alan.algorithm.practice.programmers.connectisland;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {

    int[] roots;

    public int solution(int n, int[][] costs) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        int result = 0;
        for (int[] route : costs) {
            int from = route[0], to = route[1], cost = route[2];
            int fromRoot = findRoot(from), toRoot = findRoot(to);

            if (fromRoot == toRoot) {
                continue;
            }

            result += cost;
            roots[toRoot] = fromRoot;
        }
        return result;
    }

    private int findRoot(int node) {
        if (roots[node] == node) {
            return node;
        }
        return roots[node] = findRoot(roots[node]);
    }

}

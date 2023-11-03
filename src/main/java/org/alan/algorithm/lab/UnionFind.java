package org.alan.algorithm.lab;

import java.util.List;

public class UnionFind {

    private int[] graph;

    public void initiate(List<List<Integer>> input) {
        for (List<Integer> integers : input) {
            if (integers.isEmpty()) continue;

            integers.sort(Integer::compare);
            int root = integers.get(0);
            graph[root] = root;
            for (int i = 1; i < integers.size(); i++) graph[integers.get(i)] = root;
        }
    }
}

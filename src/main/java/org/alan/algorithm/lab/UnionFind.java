package org.alan.algorithm.lab;

import java.util.stream.IntStream;

public class UnionFind {
    private final int[] roots;

    public UnionFind(int n) {
        roots = IntStream.range(0, n).toArray();
    }

    public int find(int p) {
        if (p == roots[p]) return p;
        return roots[p] = find(roots[p]);
    }

    public void merge(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) roots[rootB] = rootA;
    }
}

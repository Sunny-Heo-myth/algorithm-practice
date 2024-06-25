package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.stream.IntStream;

public class BJ10775 {
    private int[] gates;

    public String solve(String input) {
        String[] lines = input.split("\n");
        gates = IntStream.rangeClosed(0, Integer.parseInt(lines[0])).toArray();

        int count = 0;
        for (int i = 0; i < Integer.parseInt(lines[1]); i++) {
            int p = Integer.parseInt(lines[i + 2]);
            if (find(p) == 0) break;
            count++;
            union(find(p), find(p) - 1);
        }
        return String.valueOf(count);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        gates[a] = b;
    }

    private int find(int x) {
        if (x == gates[x]) return x;
        return gates[x] = find(gates[x]);
    }
}

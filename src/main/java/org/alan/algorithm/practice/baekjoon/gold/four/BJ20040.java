package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.stream.IntStream;

public class BJ20040 {
    private int[] parentOf;
    public String solve(String input) {
        String[] lines = input.split("\n");
        parentOf = IntStream.range(0, Integer.parseInt(lines[0].split(" ")[0])).toArray();
        for (int i = 1; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            int c1 = Integer.parseInt(line[0]); int c2 = Integer.parseInt(line[1]);
            int p1 = find(c1); int p2 = find(c2);
            if (p1 != p2) union(p1, p2);
            else return String.valueOf(i);
        }
        return "0";
    }

    private int find(int child) {
        if (child == parentOf[child]) return child;
        return parentOf[child] = find(parentOf[child]);
    }

    private void union(int child1, int child2) {
        int p1 = find(child1);
        int p2 = find(child2);
        if (p1 < p2) parentOf[p2] = p1;
        if (p2 < p1) parentOf[p1] = p2;
    }
}

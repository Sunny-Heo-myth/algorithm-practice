package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1068 {
    private int[] tree;
    private int[] parent;

    public String solve(String input) {
        String[] lines = input.split("\n");
        tree = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();

        int root = IntStream.range(0, tree.length).filter(i -> tree[i] == -1).findFirst().orElse(-1);
        int delete = Integer.parseInt(lines[2]);
        if (delete == root) return "0";

        int temp = tree[delete]; tree[delete] = -1;
        parent = new int[tree.length]; System.arraycopy(tree, 0, parent, 0, tree.length);
        for (int i = 0; i < parent.length; i++) find(i);

        int leaf = 0;
        loop: for (int i = 0; i < parent.length; i++) {
            if (parent[i] != root) continue;
            for (int j : tree) if (j == i) continue loop;
            leaf++;
        }

        if (leaf == 0 && temp == root) return "1";
        return String.valueOf(leaf);
    }

    private int find(int i) {
        if (parent[i] == -1) return i;
        return parent[i] = find(parent[i]);
    }

}

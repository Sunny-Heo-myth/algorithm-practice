package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ1167 {
    private int sum = 0;
    private int max = 0;
    private int maxTo = 0;
    private boolean[] node;
    private final Map<Integer, List<int[]>> edge = new HashMap<>(); // stateless

    public String solve(String input) {
        int numberOfNode = parse(input);

        int start = 1;
        node = new boolean[numberOfNode + 1];   // index refers node number
        node[start] = true;
        sum = 0;
        traverse(start);

        node = new boolean[numberOfNode + 1];
        node[maxTo] = true;
        sum = 0;
        traverse(maxTo);

        return String.valueOf(max);
    }

    private int parse(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        for (int i = 0; i < n; i++) {
            String[] line = s[i + 1].split(" ");
            List<int[]> list = new ArrayList<>();
            for (int j = 1; j < line.length - 1; j += 2) {
                list.add(new int[]{Integer.parseInt(line[j]), Integer.parseInt(line[j + 1])});
            }
            edge.put(Integer.parseInt(line[0]), list);
        }
        return n;
    }

    private void traverse(int from) {
        var list = edge.get(from);
        for (int[] pair : list) {
            int to = pair[0];
            if (node[to]) continue;

            node[to] = true;

            int cost = pair[1];
            sum += cost;

            if (sum > max) {
                max = sum;
                maxTo = to;
            }

            traverse(to);
            sum -= cost;

            node[to] = false;
        }
    }

}

package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.*;

public class BJ1967 {

    private boolean[] check;
    private int max;
    private int maxIndex;
    private Map<Integer, List<int[]>> fromToCost = new HashMap<>(); // stateless
    private int numberOfNode;   // stateless

    public String solve(String input) {
        parse(input);

        max = 0;
        check = new boolean[numberOfNode + 1];
        check[1] = true;
        traverse(1, 0);

        max = 0;
        check = new boolean[numberOfNode + 1];
        check[maxIndex] = true;
        traverse(maxIndex, 0);

        return String.valueOf(max);
    }

    private void parse(String input) {
        String[] s = input.split("\n");
        numberOfNode = Integer.parseInt(s[0]);

        for (int line = 1; line < s.length; line++) {
            int[] edge = Arrays.stream(s[line].split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] toCost1 = {edge[1], edge[2]};
            if (fromToCost.containsKey(edge[0])) fromToCost.get(edge[0]).add(toCost1);
            else fromToCost.put(edge[0], new ArrayList<>(List.of(toCost1)));

            int[] toCost2 = {edge[0], edge[2]};
            if (fromToCost.containsKey(edge[1])) fromToCost.get(edge[1]).add(toCost2);
            else fromToCost.put(edge[1], new ArrayList<>(List.of(toCost2)));
        }
    }

    private void traverse(int from, int maxUntilNow) {
        if (maxUntilNow > max) {
            max = maxUntilNow;
            maxIndex = from;
        }

        if (!fromToCost.containsKey(from)) return;

        for (int[] toCost : fromToCost.get(from)) {
            if (!check[toCost[0]]) {
                check[toCost[0]] = true;
                traverse(toCost[0], maxUntilNow + toCost[1]);
            }
        }
    }

}

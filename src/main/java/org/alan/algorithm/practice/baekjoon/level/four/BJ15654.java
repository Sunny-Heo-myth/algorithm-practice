package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ15654 {
    private int n;
    private int[] array;
    private boolean[] check;
    private final List<Integer> cache = new ArrayList<>();
    private final StringBuilder sb = new StringBuilder();

    public String solve(String input) {
        String[] s = input.split("\n");
        n = Integer.parseInt(s[0].split(" ")[1]);
        array = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        check = new boolean[array.length];

        backTracking(0);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void backTracking(int count) {
        if (count == n) {
            cache.forEach(i -> sb.append(i).append(" "));
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }

        for (int i = 0; i < check.length; i++) {
            if (check[i]) continue;

            check[i] = true;
            cache.add(array[i]);

            backTracking(count + 1);

            check[i] = false;
            cache.remove(cache.size() - 1);
        }
    }
}

package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ15663 {
    private int n;
    private int[] array;
    private boolean[] check;
    private final List<Integer> cache = new ArrayList<>();
    private final List<String> result = new ArrayList<>();

    public String solve(String input) {
        String[] s = input.split("\n");
        n = Integer.parseInt(s[0].split(" ")[1]);
        array = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        check = new boolean[array.length];

        backTracking(0);

        StringBuilder sb = new StringBuilder();
        result.stream().distinct().forEach(ss -> sb.append(ss).append("\n"));
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void backTracking(int count) {
        if (count == n) {
            StringBuilder sb = new StringBuilder();
            cache.forEach(i -> sb.append(i).append(" "));
            result.add(sb.deleteCharAt(sb.length() - 1).toString());
        }

        for (int i = 0; i < array.length; i++) {
            if (check[i]) continue;

            check[i] = true;
            cache.add(array[i]);

            backTracking(count + 1);

            check[i] = false;
            cache.remove(cache.size() - 1);
        }
    }
}

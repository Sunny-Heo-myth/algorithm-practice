package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.Arrays;

public class BJ1107 {
    private final boolean[] broken = new boolean[10];

    public String solve(String input) {
        String[] s = input.split("\n");
        int target = Integer.parseInt(s[0]);
        int result = Math.abs(target - 100);

        if (s[1].equals("0")) return String.valueOf(Integer.min(s[0].length(), result));
        else Arrays.stream(s[2].split(" ")).mapToInt(Integer::parseInt).forEach(i -> broken[i] = true);

        for (int i = 0; i < 1000000; i++) {
            String str = String.valueOf(i);

            boolean pushBroken = str.chars().map(c -> c - '0').anyMatch(idx -> broken[idx]);
            if (pushBroken) continue;

            result = Math.min(Math.abs(target - i) + str.length(), result);
        }
        return String.valueOf(result);
    }
}

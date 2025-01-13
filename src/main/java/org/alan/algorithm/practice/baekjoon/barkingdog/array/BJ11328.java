package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import java.util.Arrays;

public class BJ11328 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int[] count = new int[26];
        s[0].chars().map(i -> i - 'a').forEach(i -> count[i]++);
        s[1].chars().map(i -> i - 'a').forEach(i -> count[i]--);
        return Arrays.stream(count).filter(i -> i != 0).findAny().isPresent() ? "Impossible" : "Possible";
    }
}

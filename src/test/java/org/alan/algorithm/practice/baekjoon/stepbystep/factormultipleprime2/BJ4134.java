package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

public class BJ4134 {
    public String solve(String input) {
        // parse
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);

        int[] ints = new int[n];
        for (int i = 1; i < n + 1; i++) {
            ints[i - 1] = Integer.parseInt(s[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ints) {

        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}

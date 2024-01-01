package org.alan.algorithm.practice.baekjoon.tagged.string;

public class BJ1439 {
    public String solve(String input) {
        char[] chars = input.toCharArray();
        char now = chars[0];

        int flipCount = 1;
        for (int i = 1; i < chars.length; i++) if (chars[i] != now) {
            now = chars[i];
            flipCount++;
        }
        return String.valueOf(flipCount / 2);
    }
}

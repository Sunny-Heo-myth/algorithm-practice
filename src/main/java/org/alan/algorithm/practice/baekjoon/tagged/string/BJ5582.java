package org.alan.algorithm.practice.baekjoon.tagged.string;

public class BJ5582 {
    public String solve(String input) {
        String[] s = input.split("\n");
        for (int iLength = s[0].length(); iLength > 0; iLength--) {
            for (int i = 0; i < s[0].length() - iLength + 1; i++) {
                if (s[1].contains(s[0].substring(i, i + iLength))) {
                    return String.valueOf(iLength);
                }
            }
        }
        return "0";
    }
}

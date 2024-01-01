package org.alan.algorithm.practice.baekjoon.tagged.string;

public class BJ2744 {
    public String solve(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

public class BJ3111 {
    private final String key, text;

    public BJ3111(String input) {
        String[] lines = input.split("\n");
        key = lines[0]; text = lines[1];
    }

    public String solve() {
        int l = 0, r = text.length() - 1;
        StringBuilder left = new StringBuilder(), right = new StringBuilder();

        while (l <= r) {
            while (l <= r) {
                left.append(text.charAt(l++));
                if (left.length() < key.length()) continue;
                int start = left.length() - key.length(), end = left.length();
                if (left.substring(start, end).equals(key)) {
                    left.delete(start, end);
                    break;
                }
            }
            while (l <= r) {
                right.insert(0, text.charAt(r--));
                if (right.length() < key.length()) continue;
                int start = 0, end = key.length();
                if (right.substring(start, end).equals(key)) {
                    right.delete(start, end);
                    break;
                }
            }
        }

        left.append(right);
        while (true) {
            int i = left.indexOf(key);
            if (i == -1) break;
            left.delete(i, i + key.length());
        }
        return left.toString();
    }

}

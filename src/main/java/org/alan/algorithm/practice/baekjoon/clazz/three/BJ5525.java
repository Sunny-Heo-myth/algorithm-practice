package org.alan.algorithm.practice.baekjoon.clazz.three;

public class BJ5525 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        char[] chars = s[2].toCharArray();
        int[] memo = new int[chars.length];

        int answer = 0;
        for (int i = 1; i < chars.length - 1; i++) if (chars[i] == 'O' && chars[i + 1] == 'I') {
            memo[i + 1] = memo[i - 1] + 1;
            if (memo[i + 1] >= n && chars[i - 2 * n + 1] == 'I') answer++;
        }
        return String.valueOf(answer);
    }
}

package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Stack;

public class BJ9252 {
    public String solve(String input) {
        String[] lines = input.split("\n"); String s1 = lines[0]; String s2 = lines[1];
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) for (int j = 1; j <= s2.length(); j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) memo[i][j] = memo[i - 1][j - 1] + 1;
            else memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
        }

        int i = s1.length(); int j = s2.length();
        Stack<Character> st = new Stack<>();
        while (i > 0 && j > 0) {
            if (memo[i][j] == memo[i - 1][j]) i--;
            else if (memo[i][j] == memo[i][j - 1]) j--;
            else {
                st.push(s1.charAt(i - 1));
                i--;
                j--;
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!st.isEmpty()) answer.append(st.pop());
        return memo[s1.length()][s2.length()] + "\n" + answer;
    }
}

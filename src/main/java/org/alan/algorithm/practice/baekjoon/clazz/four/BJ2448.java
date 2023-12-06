package org.alan.algorithm.practice.baekjoon.clazz.four;

public class BJ2448 {
    private final String[] memo = new String[11];

    public String solve(String input) {
        memo[0] =
                "  *  \n" +
                " * * \n" +
                "*****";

        return recur((int) (Math.log(Integer.parseInt(input)) / Math.log(2) - 1));
    }

    private String recur(int i) {
        if (memo[i] != null) return memo[i];

        memo[i] = shift(recur(i - 1)) + "\n" + append(memo[i - 1]);
        return memo[i];
    }

    private String shift(String recur) {
        StringBuilder sb = new StringBuilder();
        String[] s = recur.split("\n");
        String repeat = " ".repeat(s[s.length - 1].length() / 2 + 1);
        for (String ss : s) sb.append(repeat).append(ss).append(repeat).append("\n");
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private String append(String s) {
        StringBuilder sb = new StringBuilder();
        for (String line : s.split("\n")) sb.append(line).append(" ").append(line).append("\n");
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}

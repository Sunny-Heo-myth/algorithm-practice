package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.stream.IntStream;

public class BJ1747 {
    public String solve(String input) {
        boolean[] net = new boolean[1003002]; net[1] = true;
        for (int factor = 2; factor * factor < net.length; factor++) {
            if (net[factor]) continue;
            for (int multiple = factor * 2; multiple < net.length; multiple += factor) net[multiple] = true;
        }

        return String.valueOf(IntStream.iterate(Integer.parseInt(input), i -> i < net.length, i -> i + 1)
                .filter(i -> !net[i] && isPalindrome(i)).findFirst().orElse(-1));
    }

    private boolean isPalindrome(int n) {
        char[] s = String.valueOf(n).toCharArray();
        return IntStream.rangeClosed(0, s.length / 2).allMatch(i -> s[i] == s[s.length - i - 1]);
    }

}

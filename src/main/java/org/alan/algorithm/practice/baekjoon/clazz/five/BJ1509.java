package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.stream.IntStream;

public class BJ1509 {

    public String solve(String input) {
        int length = input.length();
        boolean[][] palindrome = new boolean[length + 1][length + 1];
        int[] memo = IntStream.rangeClosed(0, length).map(i -> Integer.MAX_VALUE).toArray();

        for (int start = 1; start <= length; start++) {
            for (int end = start; end <= length; end++) {
                boolean flag = true;

                int s = start - 1;
                int e = end - 1;
                while (s <= e) if (input.charAt(s++) != input.charAt(e--)) {
                    flag = false;
                    break;
                }
                if (flag) palindrome[start][end] = true;
            }
        }

        for (int i = 1; i <= length; i++) for (int j = 1; j <= i; j++) {
            if (palindrome[j][i]) {
                memo[i] = Math.min(memo[i], memo[j - 1] + 1);
            }
        }
        return String.valueOf(memo[length]);
    }

}

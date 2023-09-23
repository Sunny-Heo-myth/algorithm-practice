package org.alan.algorithm.practice.baekjoon.problem;

public class BJ1850 {

    public String solve(String input) {
        String[] s = input.split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);

        StringBuilder result = new StringBuilder();

        long big, small;
        if (n >= m) {
            big = n; small = m;
        } else {
            small = n; big = m;
        }

        long remainder;
        while (small != 0) {
            remainder = big % small;
            big = small;
            small = remainder;
        }

        return getString(big, result);
    }

    private String getString(long dividend, StringBuilder result) {
        for (int i = 0; i < dividend; i++) {
            result.append("1");
        }
        return result.toString();
    }
}

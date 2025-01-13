package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

public class BJ1052 {

    public String solve(String input) {
        String[] s = input.split(" ");
        int from = Integer.parseInt(s[0]);
        int to = Integer.parseInt(s[1]);

        int n = 0;
        while (Integer.bitCount(from) > to) {
            n += from & -from;
            from += from & -from;
        }
        return String.valueOf(n);
    }


}

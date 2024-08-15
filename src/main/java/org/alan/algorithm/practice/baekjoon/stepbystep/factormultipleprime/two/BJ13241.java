package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime.two;

public class BJ13241 {
    public String solve(String input) {
        String[] s = input.split(" ");
        long i = Long.parseLong(s[0]);
        long j = Long.parseLong(s[1]);

        long big;
        long small;

        if (i == j) {
            return String.valueOf(i);

        } else {
            if (i > j) {
                big = i;
                small = j;
            } else {
                small = i;
                big = j;
            }

            if (big % small == 0) {
                return String.valueOf(big);
            }
        }

        long lcm = big * small;
        for (long divisor = small - 1; divisor >= 1; divisor--) {
            if (small % divisor == 0 && big % divisor == 0) {
                return String.valueOf(lcm / divisor);
            }
        }
        return String.valueOf(lcm);
    }
}

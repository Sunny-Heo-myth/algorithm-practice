package org.alan.algorithm.practice.baekjoon.silver.three;

public class BJ1072 {
    public String solve(String input) {
        String[] s = input.split(" ");

        long x = Long.parseLong(s[0]);
        long y = Long.parseLong(s[1]);
        long z = y * 100 / x;

        if (z >= 99) return "-1";
        long zzz = (x * (z + 1) - 100 * y) / (99 - z);
        return String.valueOf((x * (z + 1) - 100 * y) % (99 - z) == 0 ? zzz : zzz + 1);
    }

}

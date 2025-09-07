package org.alan.algorithm.practice.baekjoon.tagged.recur;

public class BJ1074 {
    public String solve(String input) {
        String[] s = input.split(" ");
        return String.valueOf(z(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), 0));
    }

    private int z(int n, int r, int c, int total) {
        if (n == 1) return r * 2 + c + total;

        int side = (int) Math.pow(2, n - 1);
        return z(n - 1, r % side, c % side, side * side * ((r / side) * 2 + (c / side)) + total);
    }
}

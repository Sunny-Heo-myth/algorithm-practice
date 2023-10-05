package org.alan.algorithm.practice.baekjoon.problem;

public class BJ2609 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int i = Integer.parseInt(s[0]);
        int j = Integer.parseInt(s[1]);

        int gcd = euclideanGcd(i, j);
        return gcd + "\n" + i * j / gcd;
    }

    private int euclideanGcd(int i, int j) {
        int big, small;
        if (i == j) return i;
        else if (i > j) {
            big = i; small = j;
        } else {
            small = i; big = j;
        }

        int remainder = big % small;
        if (remainder == 0) {
            return small;
        }

        return euclideanGcd(small, remainder);
    }
}

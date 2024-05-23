package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.regex.Pattern;

public class BJ2470 {
    public String solve(String input) {
        long[] n = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToLong(Long::parseLong).sorted().toArray();
        long min = Long.MAX_VALUE; int x = 0; int y = n.length - 1;

        int i = x; int j = y;
        while (i < j) {
            long sum = n[i] + n[j];
            long abs = Math.abs(sum);
            if (min > abs) {
                min = abs;
                x = i; y = j;
            }

            if (sum > 0) j--;
            else if (sum == 0) return n[i] + " " + n[j];
            else i++;
        }
        return n[x] + " " + n[y];
    }
}

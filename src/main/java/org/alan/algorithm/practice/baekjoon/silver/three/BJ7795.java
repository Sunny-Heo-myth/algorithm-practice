package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;

public class BJ7795 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int[] A = Pattern.compile(" ").splitAsStream(s[1]).mapToInt(Integer::parseInt).sorted().toArray();
        int[] B = Pattern.compile(" ").splitAsStream("0 " + s[2]).mapToInt(Integer::parseInt).sorted().toArray();
        int count = 0;
        int from = 0;
        for (int a : A) {
            for (int b = from; b < B.length; b++) {
                if (a > B[b]) {
                    from = b;
                } else {
                    break;
                }
            }
            count += from;
        }
        return String.valueOf(count);
    }

}

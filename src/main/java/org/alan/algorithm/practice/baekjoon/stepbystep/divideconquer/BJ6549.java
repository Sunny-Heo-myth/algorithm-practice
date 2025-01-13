package org.alan.algorithm.practice.baekjoon.stepbystep.divideconquer;

import java.util.regex.Pattern;

public class BJ6549 {
    public String solve(String input) {
        long[] a = Pattern.compile(" ").splitAsStream(input).skip(1).mapToLong(Long::parseLong).toArray();
        long size = a[0];
        for (int i = 0; i < a.length; i++) {
            int j = i;
            long min = a[j];
            while (--j >= 0) {
                min = Long.min(a[j], min);
                size = Long.max(size, (i - j + 1) * min);
            }
        }
        return String.valueOf(size);
    }
}

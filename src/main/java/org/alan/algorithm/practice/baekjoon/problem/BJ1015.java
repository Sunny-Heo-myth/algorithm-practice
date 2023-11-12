package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ1015 {
    public String solve(String input) {
        int[] a = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).mapToInt(Integer::parseInt).toArray();
        boolean[] aCheck = new boolean[a.length];

        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, b.length);
        b = Arrays.stream(b).sorted().toArray();

        int[] p = new int[a.length];
        for (int i = 0; i < b.length; i++) for (int j = 0; j < a.length; j++) {
            if (b[i] == a[j] && !aCheck[j]) {
                p[j] = i;
                aCheck[j] = true;
                break;
            }
        }

        return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}

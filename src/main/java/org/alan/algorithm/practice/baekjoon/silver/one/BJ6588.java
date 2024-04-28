package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Arrays;

public class BJ6588 {
    private static final boolean[] isP = new boolean[1000001];
    static {
        Arrays.fill(isP, true); isP[0] = false; isP[1] = false; // st
        for (int cdd = 2; cdd * cdd < isP.length; cdd++) {
            if (!isP[cdd]) continue;
            for (int notP = cdd * cdd; notP < isP.length; notP += cdd) isP[notP] = false; // st
        }
    }

    public String solve(String input) {
        int n = Integer.parseInt(input);
        for (int i = 2; i < n / 2 + 1; i++) if (isP[i] && isP[n - i]) return n + " = " + i + " + " + (n - i);
        return "Goldbach's conjecture is wrong.";
    }
}

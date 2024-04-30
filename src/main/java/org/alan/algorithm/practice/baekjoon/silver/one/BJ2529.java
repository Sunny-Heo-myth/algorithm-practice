package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BJ2529 {
    private Boolean[] inequalities;
    private boolean[] used;
    private final List<String> candidate = new ArrayList<>();

    public String solve(String input) {
        inequalities = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .map(s -> s.equals("<")).toArray(Boolean[]::new);
        used = new boolean[10];

        recur("", 0);

        return candidate.get(candidate.size() - 1) + "\n" + candidate.get(0);
    }

    private void recur(String s, int i) {
        if (i == inequalities.length + 1) {
            candidate.add(s);  // st
            return;
        }

        for (int t = 0; t < 10; t++) {
            if (used[t] || (i != 0 && !isValid(s.charAt(i - 1) - '0', t, inequalities[i - 1]))) continue;
            used[t] = true;  // st
            recur(s + t, i + 1);
            used[t] = false;  // st
        }
    }

    private boolean isValid(int m, int n, boolean b) {
        if (m == n) throw new IllegalArgumentException();
        if (b && m > n) return false;
        return b || m > n;
    }

}

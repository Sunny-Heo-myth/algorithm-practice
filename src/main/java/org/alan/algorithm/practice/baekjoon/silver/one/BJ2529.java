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

    private Boolean[] signs;
    private final boolean[] visited = new boolean[10];
    private final List<String> answer = new ArrayList<>();

    public String solve2(String input) {
        signs = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .map(s -> s.equals("<") ? Boolean.TRUE : Boolean.FALSE).toArray(Boolean[]::new);

        recur2("", 0);
        return answer.get(answer.size() - 1) + "\n" + answer.get(0);
    }

    private void recur2(String s, int i) {
        if (i == signs.length + 1) {
            answer.add(s);
            return;
        }

        for (int j = 0; j < 10; j++) {
            if (visited[j] || (i != 0 && !match(s.charAt(i - 1) - '0', j, signs[i - 1]))) continue;
            visited[j] = true;
            recur2(s + j, i + 1);
            visited[j] = false;
        }
    }

    private boolean match(int i, int j, boolean b) {
        if (i == j) throw new IllegalArgumentException();
        return (b && i < j) || (!b && i > j);
    }

}

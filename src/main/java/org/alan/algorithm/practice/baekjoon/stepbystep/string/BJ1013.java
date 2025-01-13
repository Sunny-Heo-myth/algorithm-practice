package org.alan.algorithm.practice.baekjoon.stepbystep.string;

public class BJ1013 {

    public String solve(String input) {
        return recur(input) ? "YES" : "NO";
    }

    private boolean recur(String parent) {
        if (parent.startsWith("01")) {
            if (parent.length() == 2) return true;
            return recur(parent.substring(2));
        } else if (parent.matches("100+1+[01]*")) {
            int s = parent.indexOf('1', 1);
            int e = s;
            while (parent.charAt(e) == '1') {
                if (parent.length() == e + 1) return true;
                e++;
            }
            for (int i = s; i < e; i++) if (recur(parent.substring(i + 1))) return true;
        }
        return false;
    }
}

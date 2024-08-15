package org.alan.algorithm.practice.baekjoon.stepbystep.recursion;

public class BJ4779 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        String init = "-".repeat((int) Math.pow(3, n));
        return cantor(init);
    }

    private String cantor(String input) {
        if (input.length() == 1) {
            return "-";
        }

        int oneThird = input.length() / 3;
        int twoThird = oneThird * 2;
        return cantor(input.substring(0, oneThird)) + " ".repeat(oneThird) + cantor(input.substring(twoThird));
    }
}

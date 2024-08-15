package org.alan.algorithm.practice.baekjoon.stepbystep.recursion;

public class BJ11729 {

    private StringBuilder sb;

    public String solve(String input) {
        int n = Integer.parseInt(input);
        sb = new StringBuilder();

        sb.append((int) Math.pow(2, n) - 1).append("\n");

        hanoi(1, 2, 3, n);

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void hanoi(int from, int mid, int to, int n) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(from, to, mid, n - 1);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(mid, from, to, n - 1);
    }
}

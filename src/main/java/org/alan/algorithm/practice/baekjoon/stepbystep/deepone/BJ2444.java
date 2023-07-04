package org.alan.algorithm.practice.baekjoon.stepbystep.deepone;

public class BJ2444 {
    public String solve(int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            drawTriangle(n, answer, i);
        }
        for (int i = n - 2; i >= 0; i--) {
            drawTriangle(n, answer, i);
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }

    private void drawTriangle(int n, StringBuilder answer, int i) {
        answer.append(" ".repeat(Math.max(0, n - i - 1)));
        answer.append("*".repeat(Math.max(0, 2 * i + 1)));
        answer.append("\n");
    }
}

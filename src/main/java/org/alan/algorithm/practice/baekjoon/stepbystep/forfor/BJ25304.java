package org.alan.algorithm.practice.baekjoon.stepbystep.forfor;

public class BJ25304 {
    private final String[] lines;

    public BJ25304(String input) {
        lines = input.split("\n");
    }

    public String solve() {
        int totalPrice = Integer.parseInt(lines[0]);
        int kinds = Integer.parseInt(lines[1]);
        int sum = 0;
        for (int i = 0; i < kinds; i++) {
            String[] line = lines[i + 2].split(" ");
            sum += (Integer.parseInt(line[0]) * Integer.parseInt(line[1]));
        }
        return sum == totalPrice ? "Yes" : "No";
    }
}

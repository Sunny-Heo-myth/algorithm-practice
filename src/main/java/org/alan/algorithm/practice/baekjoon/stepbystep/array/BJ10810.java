package org.alan.algorithm.practice.baekjoon.stepbystep.array;

public class BJ10810 {
    private final int[] basket;

    public BJ10810(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        basket = new int[Integer.parseInt(firstLine[0])];

        for (int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
            String[] line = lines[i + 1].split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int ballNumber = Integer.parseInt(line[2]);
            put(from, to, ballNumber);
        }

    }

    private void put(int from, int to, int ballNumber) {
        for (int i = from - 1; i < to; i++) basket[i] = ballNumber;
    }

    public String solve() {
        StringBuilder result = new StringBuilder();
        for (int j : basket) result.append(j).append(" ");
        return result.deleteCharAt(result.length() - 1).toString();
    }
}

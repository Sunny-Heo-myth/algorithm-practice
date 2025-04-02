package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import java.util.Arrays;

public class BJ1365 {
    private final int[] wires;

    public BJ1365(String input) {
        wires = Arrays.stream(input.split("\n")[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public String solve() {
        int[] memo = new int[wires.length];
        int length = 0;

        for (int wire : wires) {
            int i = Arrays.binarySearch(memo, 0, length, wire);
            if (i < 0) i = -(i + 1);
            memo[i] = wire;
            if (i == length) length++;
        }
        return String.valueOf(wires.length - length);
    }
}

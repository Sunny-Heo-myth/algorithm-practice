package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletrianglestep;

import java.util.Arrays;

public class BJ14215 {
    public String solve(String input) {
        int[] sides = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        if (sides[0] + sides[1] > sides[2]) {
            return String.valueOf(sides[0] + sides[1] + sides[2]);
        }

        return String.valueOf((sides[0] + sides[1]) * 2 - 1);
    }
}

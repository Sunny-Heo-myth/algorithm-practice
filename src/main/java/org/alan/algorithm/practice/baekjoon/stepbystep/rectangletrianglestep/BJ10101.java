package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletrianglestep;

import java.util.Arrays;

public class BJ10101 {

    private static final String EQUILATERAL = "Equilateral";
    private static final String ISOSCELES = "Isosceles";
    private static final String SCALENE = "Scalene";
    private static final String ERROR = "Error";

    public String solve(String input) {
        int[] angles = Arrays.stream(input.split("\n")).mapToInt(Integer::parseInt).toArray();
        if (Arrays.stream(angles).sum() != 180) {
            return ERROR;
        }

        if (Arrays.stream(angles).filter(angle -> angle == 60).count() == 3) {
            return EQUILATERAL;
        }


        if (angles[0] != angles[1]
                && angles[1] != angles[2]
                && angles[2] != angles[0]) {
            return SCALENE;
        }

        return ISOSCELES;
    }
}

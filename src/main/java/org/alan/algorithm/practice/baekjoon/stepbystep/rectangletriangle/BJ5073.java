package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle;

import java.util.Arrays;
import java.util.Objects;

public class BJ5073 {

    private static final String EQUILATERAL = "Equilateral";
    private static final String ISOSCELES = "Isosceles";
    private static final String SCALENE = "Scalene";
    private static final String INVALID = "Invalid";

    public String solve(String input) {
        String[] lines = input.split("\n");

        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if (Objects.equals(line, "0 0 0")) {
                break;
            }

            int[] sides = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            if (sides[0] + sides[1] <= sides[2]) {
                sb.append(INVALID).append("\n");
                continue;
            }

            if (sides[0] == sides[1]
                    && sides[1] == sides[2]) {
                sb.append(EQUILATERAL).append("\n");
                continue;
            }

            if (sides[0] != sides[1]
                    && sides[1] != sides[2]
                    && sides[2] != sides[0]) {
                sb.append(SCALENE).append("\n");
                continue;
            }

            sb.append(ISOSCELES).append("\n");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}

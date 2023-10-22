package org.alan.algorithm.practice.baekjoon.level.one;

import java.util.Arrays;

public class BJ2920 {
    public String solve(String input) {
        int check;
        int[] array = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        check = 8;
        while (--check >= 0) if (array[7 - check] != 8 - check) break;
        if (check == -1) return "ascending";

        check = 8;
        while (--check >= 0) if (array[7 - check] != check + 1) break;
        if (check == -1) return "descending";

        return "mixed";
    }
}

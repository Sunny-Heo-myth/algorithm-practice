package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import java.util.Objects;

public class BJ17609 {
    private boolean flag = false;

    public String solve(String input) {
        int mid = input.length() / 2;
        int i = 0;

        while (i < mid) {
            if (input.charAt(i) == input.charAt(input.length() - i - 1)) {
                i++;
                continue;
            }

            if (flag) return "2";

            flag = true;
            if (Objects.equals(solve(input.substring(i , input.length() - i - 1)), "0")) return "1";
            if (Objects.equals(solve(input.substring(i + 1 , input.length() - i)), "0")) return "1";
        }
        return "0";
    }

}

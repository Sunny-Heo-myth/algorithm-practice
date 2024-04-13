package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;

public class BJ18310 {
    public String solve(String input) {
        int[] houses = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).mapToInt(Integer::parseInt).sorted().toArray();
        if (houses.length % 2 == 0) return String.valueOf(houses[houses.length / 2 - 1]);
        else return String.valueOf(houses[houses.length / 2]);
    }
}

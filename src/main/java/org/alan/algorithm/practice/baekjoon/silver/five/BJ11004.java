package org.alan.algorithm.practice.baekjoon.silver.five;

import java.util.regex.Pattern;

public class BJ11004 {
    public String solve(String input) {
        String[] lineArray = input.split("\n");
        return String.valueOf(Pattern.compile(" ").splitAsStream(lineArray[1])
                .mapToInt(Integer::parseInt).sorted().skip(Integer.parseInt(lineArray[0].split(" ")[1]) - 1)
                .findFirst().orElse(-1));
    }
}

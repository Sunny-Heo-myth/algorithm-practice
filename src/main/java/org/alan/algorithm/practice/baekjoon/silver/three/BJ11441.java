package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ11441 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int[] ints = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();
        int[] sums = new int[ints.length + 1];
        int sum = 0;
        for (int i = 1; i <= ints.length; i++) {
            sum += ints[i - 1];
            sums[i] = sum;
        }

        return Pattern.compile("\n").splitAsStream(input).skip(3).map(s -> {
            String[] line = s.split(" ");
            int from = Integer.parseInt(line[0]) - 1;
            int to = Integer.parseInt(line[1]);
            return String.valueOf(sums[to] - sums[from]);
        }).collect(Collectors.joining("\n"));
    }
}

package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ10830 {
    private final int DIVISOR = 1000;
    private int[][] matrix; // state does not change.
    private final Map<Long, int[][]> memo = new HashMap<>();

    public String solve(String input) {
        long times = parse(input);
        return write(power(matrix, times));
    }

    private long parse(String input) {
        String[] s = input.split("\n");
        String[] ss = s[0].split(" ");
        int n = Integer.parseInt(ss[0]);
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++)
            matrix[i] = Arrays.stream(s[i + 1].split(" "))
                    .mapToInt(Integer::parseInt)
                    .map(ii -> ii % DIVISOR)    // **** WARNING ****
                    .toArray();
        return Long.parseLong(ss[1]);
    }

    private String write(int[][] multiply) {
        return Arrays.stream(multiply)
                .map(ints -> Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

    private int[][] power(int[][] parameter, long times) {
        if (times == 1) return parameter;

        if (memo.containsKey(times)) return memo.get(times);

        int[][] result;
        long halfTimes = times / 2;

        int[][] halfPower = power(parameter, halfTimes);
        if (times % 2 == 0) result = multiply(halfPower, halfPower);
        else result = multiply(halfPower, multiply(halfPower, matrix));

        memo.put(times, result);
        return result;
    }

    private int[][] multiply(int[][] left, int[][] right) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int x = 0; x < matrix.length; x++) for (int j = 0; j < matrix.length; j++)
            result[x][j] = getNumber(left, right, x, j);
        return result;
    }

    private int getNumber(int[][] left, int[][] right, int x, int y) {
        return IntStream.range(0, matrix.length).map(k -> left[x][k] * right[k][y]).sum() % DIVISOR;
    }

}

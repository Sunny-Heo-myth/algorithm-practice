package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        StringBuilder sb = new StringBuilder();
        for (int[] ints : multiply) {
            for (int j : ints) sb.append(j).append(" ");
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
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
        for (int i = 0; i < matrix.length; i++) for (int j = 0; j < matrix.length; j++)
            result[i][j] = getNumber(left, right, i, j);
        return result;
    }

    private int getNumber(int[][] left, int[][] right, int x, int y) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) sum += left[x][i] * right[i][y];
        return sum % DIVISOR;
    }

}

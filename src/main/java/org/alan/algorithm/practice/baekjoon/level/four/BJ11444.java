package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.HashMap;
import java.util.Map;

public class BJ11444 {
    private final Map<Long, long[][]> memo = new HashMap<>();
    private final long[][] base = {{1, 1}, {1, 0}};  // stateless

    public String solve(String input) {
        return String.valueOf(power(base, Long.parseLong(input) - 1)[0][0]);
    }

    private long[][] power(long[][] parameter, long times) {
        if (times == 1 || times == 0) return parameter;
        if (memo.containsKey(times)) return memo.get(times);

        long[][] half = power(parameter, times / 2);
        long[][] result = multiply(half, half);
        if (times % 2 == 1) result = multiply(result, base);

        memo.put(times, result);
        return result;
    }

    private long[][] multiply(long[][] left, long[][] right) {
        long[][] result = new long[base.length][base.length];
        for (int i = 0; i < base.length; i++) for (int j = 0; j < base.length; j++)
            result[i][j] = calculate(left, right, i, j);
        return result;
    }

    private long calculate(long[][] left, long[][] right, int x, int y) {
        long result = 0;
        for (int i = 0; i < base.length; i++) result += left[x][i] * right[i][y];
        return result % 1000000007;
    }
}

package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BJ12850 {

    public String solve(String input) {
        int init = Integer.parseInt(input);
        Stack<Integer> stack = new Stack<>();
        Map<Integer, long[][]> memo = new HashMap<>();

        stack.push(init);
        memo.put(1, new long[][]{
                {0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 0, 0, 1, 0}
        });
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (memo.containsKey(pop)) continue;

            int a = pop / 2;
            int b = pop - a;
            if (memo.containsKey(a) && memo.containsKey(b)) {
                memo.put(pop, multiply(memo.get(a), memo.get(b)));
                continue;
            }

            stack.push(pop);
            if (!memo.containsKey(a)) stack.push(a);
            if (!memo.containsKey(b)) stack.push(b);
        }
        return String.valueOf(memo.get(init)[0][0]);
    }

    private long[][] multiply(long[][] x, long[][] y) {
        long[][] result = new long[8][8];
        for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) {
            long element = 0;
            for (int k = 0; k < 8; k++) element += (x[i][k] * y[k][j]);
            result[i][j] = element % 1_000_000_007;
        }
        return result;
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import java.util.Stack;
import java.util.stream.LongStream;

public class BJ15988 {
    private final long[] memo = LongStream.concat(
            LongStream.of(0, 1, 2, 4),
            LongStream.generate(() -> 0).limit(999997)
            ).toArray();

    public String solve(String input) {
        int n = Integer.parseInt(input);
        Stack<Integer> subs = new Stack<>();

        subs.push(n);
        while (!subs.isEmpty()) {
            int x = subs.pop();
            if (memo[x] != 0) continue;

            if (memo[x - 1] != 0 && memo[x - 2] != 0 && memo[x - 3] != 0) {
                memo[x] = (memo[x - 1] + memo[x - 2] + memo[x - 3]) % 1_000_000_009;
                continue;
            }

            subs.push(x);
            if (memo[x - 1] == 0) subs.push(x - 1);
            if (memo[x - 2] == 0) subs.push(x - 2);
            if (memo[x - 3] == 0) subs.push(x - 3);
        }
        return String.valueOf(memo[n]);
    }
}

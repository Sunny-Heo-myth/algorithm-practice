package org.alan.algorithm.practice.baekjoon.problem;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class BJ10093 {
    public String solve(String input) {
        String[] s = input.split(" ");
        long i = Long.parseLong(s[0]);
        long j = Long.parseLong(s[1]);
        if (i == j) return "0";

        long fromExclusive = Math.min(i, j);
        long toExclusive = Math.max(i, j);
        long diff = toExclusive - fromExclusive - 1;
        if (diff == 0) return "0";

        return diff + "\n" + LongStream.range(fromExclusive + 1, toExclusive)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}

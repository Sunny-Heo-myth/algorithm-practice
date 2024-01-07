package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ2217 {
    public String solve(String input) {
        int[] rope = Pattern.compile("\n").splitAsStream(input).skip(1)
                .mapToInt(Integer::parseInt).sorted().toArray();
        return String.valueOf(IntStream.range(0, rope.length).map(i -> rope[i] * (rope.length - i)).max().orElse(0));
    }
}

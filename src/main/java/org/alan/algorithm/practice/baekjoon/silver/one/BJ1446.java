package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1446 {
    public String solve(String input) {
        int d = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
        int[] route = IntStream.rangeClosed(0, d).toArray();
        input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .filter(ints -> ints[1] <= d && ints[1] - ints[0] > ints[2])
                .sorted(Comparator.comparingInt(ints -> ints[1]))
                .filter(ints -> route[ints[1]] > route[ints[0]] + ints[2])
                .forEach(ints -> {
                    int shorten = route[ints[1]] - (route[ints[0]] + ints[2]);
                    IntStream.rangeClosed(ints[1], d).forEach(i -> route[i] -= shorten);
                });
        return String.valueOf(route[d]);
    }
}

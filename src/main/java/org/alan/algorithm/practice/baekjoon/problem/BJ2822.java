package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ2822 {
    public String solve(String input) {
        int[] arr = Pattern.compile("\n").splitAsStream(input).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(arr).sorted().skip(3).sum() + "\n" +
                IntStream.range(0, 8)
                        .mapToObj(i -> new int[]{i, arr[i]})
                        .sorted(Comparator.comparingInt(ints -> ints[1]))
                        .skip(3)
                        .mapToInt(ints -> ints[0] + 1)
                        .sorted()
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
    }
}

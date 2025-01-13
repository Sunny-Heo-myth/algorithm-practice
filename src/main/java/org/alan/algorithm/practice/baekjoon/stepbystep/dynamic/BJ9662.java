package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ9662 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int n = Integer.parseInt(lines[0]);
        int[] picks = Pattern.compile(" ").splitAsStream(lines[2])
                .mapToInt(Integer::parseInt)
                .toArray();

        int MAX_PERIOD = 600;
        boolean[] memo = new boolean[MAX_PERIOD * 2 + 1];
        Arrays.stream(picks).forEach(i -> memo[i] = true);
        IntStream.rangeClosed(1, memo.length).forEach(i ->
                memo[i] = Arrays.stream(picks)
                        .map(pick -> i - pick)
                        .takeWhile(j -> j >= 0)
                        .filter(j -> !memo[j])
                        .findAny().isPresent());

        return "TODO";
    }



















    public String solve2(String input) {
        String[] lines = input.split("\n");
        int[] picks = Pattern.compile(" ").splitAsStream(lines[2])
                .mapToInt(Integer::parseInt)
                .toArray();

        int MAX_LEN = 1200;
        boolean[] memo = new boolean[MAX_LEN + 1];
        Arrays.stream(picks).forEach(i -> memo[i] = true);
        IntStream.range(picks[0] + 1, memo.length).forEach(i ->
                memo[i] = Arrays.stream(picks)
                        .map(j -> i - j)
                        .filter(j -> j >= 0 && !memo[j])
                        .findAny().isPresent());

        int n = Integer.parseInt(lines[0]);
        if (n <= MAX_LEN) return String.valueOf(IntStream.rangeClosed(1, n).filter(i -> !memo[i]).count());

        int offset = MAX_LEN / 2;
        int period = IntStream.rangeClosed(1, offset).filter(cycle ->
                IntStream.iterate(offset, i -> i + cycle < MAX_LEN, i -> i + 1)    // start from short cycles
                        .filter(i -> memo[i] != memo[i + cycle])
                        .findAny().isEmpty())
                .findFirst().orElse(0);

        long prefix = IntStream.range(1, offset).filter(i -> !memo[i]).count();
        long perCycle = IntStream.range(offset, offset + period).filter(i -> !memo[i]).count();

        long lengthAfterOffset = (long) n - offset + 1;
        long cycles = lengthAfterOffset / period;
        long remainder  = lengthAfterOffset % period;

        long afterPrefix = cycles * perCycle
                + IntStream.range(offset, offset + (int) remainder).filter(i -> !memo[i]).count();

        return String.valueOf(prefix + afterPrefix);
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

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

        boolean[] memo = new boolean[1201];
        Arrays.stream(picks).forEach(i -> memo[i] = true);
        IntStream.range(picks[0] + 1, memo.length).forEach(i ->
                memo[i] = Arrays.stream(picks)
                        .map(j -> i - j)
                        .filter(j -> j >= 0 && !memo[j])
                        .findAny().isPresent());

        if (n < memo.length) {
            return String.valueOf(IntStream.rangeClosed(1, n).filter(i -> !memo[i]).count());
        }

        // find a cycle
        int period = 1;
        loop: for (int cd = 600; cd >= 1; cd--) {
            for (int i = memo.length - 1; i >= memo.length - 1 - cd; i--) for (int j = i - cd; j >= 0; j -= cd)
                if (memo[j] != memo[i]) continue loop;
            period = cd;
            break;
        }

        return String.valueOf(
                (n / period) * IntStream.rangeClosed(1, period).filter(i -> !memo[i]).count()
                        + IntStream.rangeClosed(1, n % period).filter(i -> !memo[i]).count());
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

package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ10804 {
    public String solve(String input) {
        int[] cards = IntStream.range(0, 21).toArray();
        int[][] swaps = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        for (int[] swap : swaps) {
            int from = swap[0];
            int to = swap[1];
            int size = to - from + 1;

            List<Integer> list = Arrays.stream(cards).skip(from).limit(size).boxed().collect(Collectors.toList());
            Collections.reverse(list);
            System.arraycopy(list.stream().mapToInt(Integer::intValue).toArray(), 0, cards, from, size);
        }
        return Arrays.stream(cards).skip(1).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}

package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BJ10973 {

    public String solve(String input) {
        int[] n = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        int idx = IntStream.iterate(n.length - 1, i -> i > 0, i -> i - 1)
                .filter(i -> n[i - 1] > n[i]).findFirst().orElse(-1);
        if (idx == -1) return "-1";

        int[] nextIdx = IntStream.iterate(idx, i -> i < n.length, i -> i + 1).filter(i -> n[idx - 1] >= n[i])
                .mapToObj(i -> new int[]{i, n[i]}).max(Comparator.comparingInt(ints -> ints[1])).orElse(null);

        int temp = n[idx - 1];
        n[idx - 1] = n[nextIdx[0]];
        n[nextIdx[0]] = temp;

        List<Integer> nl = Arrays.stream(n).boxed().collect(Collectors.toList());
        return Stream.concat(nl.subList(0, idx).stream(), nl.subList(idx, nl.size()).stream().sorted(Comparator.reverseOrder()))
                .map(String::valueOf).collect(Collectors.joining(" "));
    }
}

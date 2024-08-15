package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesum;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BJ10986 {

    public String solve(String input) {
        String[] s = input.split("\n");
        int divisor = Integer.parseInt(s[0].split(" ")[1]);

        Long[] array = Arrays.stream(s[1].split(" ")).map(Long::valueOf).toArray(Long[]::new);
        for (int i = 1; i < array.length; i++) array[i] += array[i - 1];    // cumulate sum
        for (int i = 0; i < array.length; i++) array[i] %= divisor; // calculate remainder

        Map<Long, Integer> map = Arrays.stream(array)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, i -> 1, Integer::sum)));

        long count = map.getOrDefault(0L, 0);
        count += map.values().stream()
                .mapToLong(i -> i > 1 ? (long) i * (i - 1) / 2 : 0)
                .sum();

        return String.valueOf(count);
    }
}

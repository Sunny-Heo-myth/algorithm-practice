package org.alan.algorithm.practice.baekjoon.tagged.sort;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BJ11652 {
    private final Map<Long, Long> frequency;

    public BJ11652(String input) {
        frequency = input.lines().skip(1).map(Long::parseLong)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String solve() {
        return String.valueOf(frequency.entrySet().stream()
                .min(Comparator
                        .<Map.Entry<Long, Long>>comparingLong(Map.Entry::getValue)
                        .reversed()
                        .thenComparingLong(Map.Entry::getKey))
                .orElseThrow().getKey());
    }

}

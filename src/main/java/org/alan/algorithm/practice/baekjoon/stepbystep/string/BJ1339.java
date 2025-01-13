package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1339 {
    public String solve(String input) {
        int[] assignment = new int[26]; AtomicInteger n = new AtomicInteger(9);
        input.lines().skip(1).flatMap(s -> IntStream.range(0, s.length()).mapToObj(i ->
                        new AbstractMap.SimpleEntry<>(s.charAt(i), (int) Math.pow(10, s.length() - i - 1))))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> assignment[entry.getKey() - 'A'] = n.getAndDecrement());

        return String.valueOf(input.lines().skip(1).mapToInt(s -> Integer.parseInt(
                s.chars().mapToObj(ch -> String.valueOf(assignment[ch - 'A'])).collect(Collectors.joining()))).sum());
    }
}

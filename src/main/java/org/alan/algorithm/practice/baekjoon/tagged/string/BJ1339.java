package org.alan.algorithm.practice.baekjoon.tagged.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1339 {
    public String solve(String input) {
        Map<Character, Integer> map = new HashMap<>();
        input.lines().skip(1).forEach(s -> IntStream.range(0, s.length()).forEach(i -> map.put(
                s.charAt(i), map.getOrDefault(s.charAt(i), 0) + (int) Math.pow(10, s.length() - i - 1))));

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] assignment = new int[26]; int n = 9;
        for (var entry : list) assignment[entry.getKey() - 'A'] = n--;

        return String.valueOf(input.lines().skip(1).mapToInt(s -> Integer.parseInt(
                s.chars().mapToObj(ch -> String.valueOf(assignment[ch - 'A'])).collect(Collectors.joining()))).sum());
    }
}

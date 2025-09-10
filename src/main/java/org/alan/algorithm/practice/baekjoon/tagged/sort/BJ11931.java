package org.alan.algorithm.practice.baekjoon.tagged.sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BJ11931 {
    private final List<Integer> list;

    public BJ11931(String input) {
        list = input.lines().skip(1).map(Integer::parseInt).sorted().collect(Collectors.toList());
    }

    public String solve() {
        Collections.reverse(list);
        return list.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}

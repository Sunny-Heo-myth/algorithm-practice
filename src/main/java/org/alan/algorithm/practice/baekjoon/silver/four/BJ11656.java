package org.alan.algorithm.practice.baekjoon.silver.four;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BJ11656 {
    public String solve(String input) {
        List<String> stringList = new ArrayList<>();
        for (int startInclusive = 0; startInclusive < input.length(); startInclusive++) {
            stringList.add(input.substring(startInclusive));
        }
        return stringList.stream().sorted().collect(Collectors.joining("\n"));
    }
}

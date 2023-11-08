package org.alan.algorithm.practice.baekjoon.level.three;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ17219 {
    public String solve(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        Map<String, String> map = IntStream.range(1, n + 1)
                .mapToObj(i -> s[i].split(" "))
                .collect(Collectors.toMap(ss -> ss[0], ss -> ss[1]));

        return IntStream.range(n + 1, m + n + 1)
                .mapToObj(i -> map.get(s[i]))
                .collect(Collectors.joining("\n"));
    }
}

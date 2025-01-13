package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ5052 {
    public String solve(String input) {
        String[] lines = input.lines().skip(1).toArray(String[]::new);
        for (int i = 0; i < lines.length; i++) for (int j = 0; j < lines.length; j++)
            if (i != j && (Pattern.compile(lines[i]).matcher(lines[j]).find())) return "NO";
        return "YES";
    }

    public String solve2(String input) {
        String[] lines = input.lines().skip(1).sorted().toArray(String[]::new);
        return IntStream.range(0, lines.length - 1).filter(i -> lines[i + 1].startsWith(lines[i]))
                .findFirst().isPresent() ? "NO" : "YES";
    }
}

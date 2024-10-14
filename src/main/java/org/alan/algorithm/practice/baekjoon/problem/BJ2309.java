package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BJ2309 {
    public String solve(String input) {
        int[] nine = input.lines().mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(nine).sum();

        loop: for (int i = 0; i < 9; i++) for (int j = i + 1; j < 9; j++) if (sum - nine[i] - nine[j] == 100) {
            nine[i] = 0; nine[j] = 0;
            break loop;
        }

        return Arrays.stream(nine)
                .filter(i -> i != 0)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("\n"));
    }
}

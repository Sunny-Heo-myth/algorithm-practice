package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ2212 {

    public String solve(String input) {
        String[] lines = input.split("\n");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);
        if(k >= n) return "0";

        int[] array = Pattern.compile(" ").splitAsStream(lines[2]).mapToInt(Integer::parseInt)
                .sorted().toArray(); // Nlg(N)

        int[] differ = IntStream.range(0, n - 1).map(i -> array[i + 1] - array[i]).boxed()
                .sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        return String.valueOf(Arrays.stream(differ, k - 1, n - 1).sum());
    }
}

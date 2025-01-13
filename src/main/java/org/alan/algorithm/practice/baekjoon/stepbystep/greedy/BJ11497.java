package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ11497 {
    public String solve(String input) {
        int[] ints = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).sorted().toArray();

        int[] answer = new int[ints.length];
        answer[0] = ints[0];
        int i = 1;
        int j = answer.length - 1;
        int k = 1;
        while (i < j) {
            answer[j--] = ints[k++];
            answer[i++] = ints[k++];
        }
        if (i == j) answer[i] = ints[k];
        return String.valueOf(Math.max(
                IntStream.range(0, answer.length - 1).map(n -> Math.abs(answer[n] - answer[n + 1])).max().orElse(-1),
                Math.abs(answer[0] - answer[answer.length - 1])));
    }
}

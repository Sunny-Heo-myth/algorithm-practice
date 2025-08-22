package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.Arrays;

public class BJ1931_2 {
    private final int[][] sorted;

    public BJ1931_2(String input) {
        sorted = input.lines().skip(1)
                .map(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray())
                .sorted((lec1, lec2) -> lec1[1] != lec2[1] ? lec1[1] - lec2[1] : lec1[0] - lec2[0])
                .toArray(int[][]::new);
    }

    public String solve() {
        int lastLectureEnded = 0, count = 0;
        for (int[] lecture : sorted) {
            int start = lecture[0], end = lecture[1];
            if (lastLectureEnded <= start) {
                lastLectureEnded = end;
                count++;
            }
        }
        return String.valueOf(count);
    }
}

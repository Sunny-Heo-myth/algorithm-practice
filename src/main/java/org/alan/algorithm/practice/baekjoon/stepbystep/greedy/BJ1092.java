package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ1092 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        List<Integer> craneList = Pattern.compile(" ").splitAsStream(lines[1])
                .map(Integer::parseInt).sorted((a, b) -> b - a).collect(Collectors.toList());
        List<Integer> containerList = Pattern.compile(" ").splitAsStream(lines[3])
                .map(Integer::parseInt).sorted((a, b) -> b - a).collect(Collectors.toList());
        if (containerList.get(0) > craneList.get(0)) return "-1";

        int day = 0;
        while (!containerList.isEmpty()) {
            int boxIdx = 0, craneIdx = 0;

            while (craneIdx < craneList.size()) {
                if (boxIdx == containerList.size()) {
                    break;
                } else if (craneList.get(craneIdx) >= containerList.get(boxIdx)) {
                    containerList.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }

            day++;
        }
        return String.valueOf(day);
    }
}

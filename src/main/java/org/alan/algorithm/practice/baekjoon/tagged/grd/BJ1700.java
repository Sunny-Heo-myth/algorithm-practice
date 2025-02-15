package org.alan.algorithm.practice.baekjoon.tagged.grd;

import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1700 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int max = Integer.parseInt(lines[0].split(" ")[0]);
        int[] devices = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();

        int unplugged = 0;
        Set<Integer> multiTab = new HashSet<>();
        for (int i = 0; i < devices.length; i++) {
            int addable = devices[i];
            if (multiTab.contains(addable)) continue;

            if (multiTab.size() < max) {
                multiTab.add(addable);
                continue;
            }

            int removable = -1, farthestIdx = -1;
            for (int plugged : multiTab) {
                OptionalInt nextUsageIdx = IntStream.range(i + 1, devices.length)
                        .filter(j -> devices[j] == plugged)
                        .findFirst();

                if (nextUsageIdx.isEmpty()) {
                    removable = plugged;
                    break;
                } else if (nextUsageIdx.getAsInt() > farthestIdx) {
                    farthestIdx = nextUsageIdx.getAsInt();
                    removable = plugged;
                }
            }

            multiTab.remove(removable);
            multiTab.add(addable);
            unplugged++;
        }
        return String.valueOf(unplugged);
    }
}


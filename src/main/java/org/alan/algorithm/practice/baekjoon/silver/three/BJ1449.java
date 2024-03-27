package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;

public class BJ1449 {
    public String solve(String input) {
        String[] line = input.split("\n");
        int tapeLength = Integer.parseInt(line[0].split(" ")[1]);
        int[] pipeIdxArray = Pattern.compile(" ").splitAsStream(line[1]).mapToInt(Integer::parseInt).sorted().toArray();

        int count = 1;
        int baseIdx = 0;
        for (int i = 0; i < pipeIdxArray.length; i++) {
            if (pipeIdxArray[i] - pipeIdxArray[baseIdx] > tapeLength - 1) {
                baseIdx = i;
                count++;
            }
        }

        return String.valueOf(count);
    }
}

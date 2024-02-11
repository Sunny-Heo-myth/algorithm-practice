package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ2467 {
    public String solve(String input) {
        int[] liquid = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).mapToInt(Integer::parseInt).toArray();
        int leftIdx = 0, rightIdx = liquid.length - 1;
        int min = Integer.MAX_VALUE;
        int liquid1 = -1;
        int liquid2 = -1;
        while (leftIdx < rightIdx) {
            int sum = liquid[leftIdx] + liquid[rightIdx];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                liquid1 = liquid[leftIdx];
                liquid2 = liquid[rightIdx];
            }
            if (sum >= 0) rightIdx--;
            else leftIdx++;
        }
        return liquid1 + " " + liquid2;
    }

}

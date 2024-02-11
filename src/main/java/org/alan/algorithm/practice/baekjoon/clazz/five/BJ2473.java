package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ2473 {
    public String solve(String input) {
        long[] liquids = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToLong(Long::parseLong).sorted().toArray();
        long leftLiquid = -1, midLiquid = -1, rightLiquid = -1;
        long currentMin = Long.MAX_VALUE;

        for (int leftIdx = 0; leftIdx < liquids.length - 2; leftIdx++) {
            int midIdx = leftIdx + 1, rightIdx = liquids.length - 1;
            while (midIdx < rightIdx) {
                long sum = liquids[leftIdx] + liquids[midIdx] + liquids[rightIdx];
                if (currentMin > Math.abs(sum)) {
                    currentMin = Math.abs(sum);
                    leftLiquid = liquids[leftIdx]; midLiquid = liquids[midIdx]; rightLiquid = liquids[rightIdx];
                }

                if (sum >= 0) rightIdx--;
                else midIdx++;
            }
        }
        return leftLiquid + " " + midLiquid + " " + rightLiquid;
    }
}

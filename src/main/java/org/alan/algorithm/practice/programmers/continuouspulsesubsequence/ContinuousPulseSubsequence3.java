package org.alan.algorithm.practice.programmers.continuouspulsesubsequence;

import java.util.Arrays;

/**
 * idea 1: sum from n to m = (sum from 1 to m) - (sum from 1 to n - 1)
 * idea 2: absolute(a - b) = getFurthestDistance from a to b
 */
public class ContinuousPulseSubsequence3 {
    public long solution(int[] sequence) {
        long[] array = Arrays.stream(sequence).asLongStream().toArray();
        long[] accumulativeSum = new long[array.length + 1];
        for (int i = 1; i < accumulativeSum.length; i++) {
            accumulativeSum[i] = accumulativeSum[i - 1];
            accumulativeSum[i] += i % 2 == 0 ? array[i - 1] : -array[i - 1];
        }
        return getFurthestDistance(accumulativeSum);
    }

    private long getFurthestDistance(long[] array) {
        long min = 100001;
        long max = -100001;
        for (long sumForNow : array) {
            if (min > sumForNow) {
                min = sumForNow;
            }
            if (max < sumForNow) {
                max = sumForNow;
            }
        }
        return Math.abs(max - min);
    }

}

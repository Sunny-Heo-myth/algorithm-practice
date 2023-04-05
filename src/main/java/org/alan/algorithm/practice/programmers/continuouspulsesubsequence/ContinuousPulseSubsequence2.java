package org.alan.algorithm.practice.programmers.continuouspulsesubsequence;

import java.util.Arrays;

public class ContinuousPulseSubsequence2 {

    public long solution(int[] input) {
        long[] array = Arrays.stream(input).asLongStream().toArray();
        long[] cumulativeSum = new long[input.length + 1];  // Each element is initiated with 0.

        for (int i = 1; i < cumulativeSum.length; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1];
            cumulativeSum[i] += i % 2 == 0 ? array[i - 1] : -array[i - 1];
        }
        return differ(cumulativeSum);
    }

    private long differ(long[] cumulativeSum) {
        long min = 100001;
        long max = -100001;
        for (long sumForNow : cumulativeSum) {
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

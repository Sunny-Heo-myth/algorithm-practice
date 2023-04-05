package org.alan.algorithm.practice.programmers.continuouspulsesubsequence;

import java.util.Arrays;

public class ContinuousPulseSubsequence {

    public long solution(int[] sequence) {
        long[] array = Arrays.stream(sequence).asLongStream().toArray();
        long[] sum = new long[sequence.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1];
            sum[i] += i % 2 == 0 ? array[i - 1] * -1 : array[i - 1];
        }
        return differ(sum);
    }

    private long differ(long[] sum) {
        long max = -100001;
        long min = 100001;
        for (long sumForNow : sum) {
            if (max < sumForNow) {
                max = sumForNow;
            }
            if (min > sumForNow) {
                min = sumForNow;
            }
        }
        return Math.abs(max - min);
    }


}

package org.alan.algorithm.practice.programmers.numbergame;

import java.util.Arrays;

public class NumberGame2 {
    public int solution(int[] inputA, int[] inputB) {
        Arrays.sort(inputA);
        Arrays.sort(inputB);

        int aIdx = 0, bIdx = 0, result = 0;
        for (int i = 0; i < inputA.length; i++) {
            if (inputA[aIdx] >= inputB[bIdx]) {
                bIdx++;
            } else {
                aIdx++; bIdx++; result++;
            }
        }
        return result;
    }
}
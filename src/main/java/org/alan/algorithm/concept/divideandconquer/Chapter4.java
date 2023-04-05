package org.alan.algorithm.concept.divideandconquer;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Chapter4 {

    public Answer findMaximumArray(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            return new Answer(array[firstIndex], firstIndex, lastIndex);
        } else {
            int middle = Math.floorDiv(firstIndex + lastIndex, 2);
            Answer left = findMaximumArray(array, firstIndex, middle);
            Answer cross = findMaximumCrossArray(array, firstIndex, middle, lastIndex);
            Answer right = findMaximumArray(array, middle + 1, lastIndex);

            if (left.maxSum >= cross.maxSum && left.maxSum >= right.maxSum) {
                return left;
            } else if (cross.maxSum >= left.maxSum && cross.maxSum >= right.maxSum) {
                return cross;
            } else {
                return right;
            }
        }
    }

    private Answer findMaximumCrossArray(int[] array, int first, int middle, int last) {
        int leftResult = Integer.MIN_VALUE;
        int leftIndex = middle;
        int leftSum = 0;
        for (int i = middle; i >= first; i--) {
            leftSum += array[i];
            if (leftSum > leftResult) {
                leftResult = leftSum;
                leftIndex = i;
            }
        }

        int rightResult = Integer.MIN_VALUE;
        int rightIndex = middle + 1;
        int rightSum = 0;
        for (int i = middle + 1; i <= last; i++) {
            rightSum += array[i];
            if (rightSum > rightResult) {
                rightResult = rightSum;
                rightIndex = i;
            }
        }

        return new Answer(leftResult + rightResult, leftIndex, rightIndex);
    }

    public Answer findMaximumArray_bruteForce(int[] array) {
        int result = Integer.MIN_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum > result) {
                    result = sum;
                    leftIndex = i;
                    rightIndex = j;
                }
            }
        }
        return new Answer(result, leftIndex, rightIndex);
    }

    @Getter
    @AllArgsConstructor
    static class Answer {
        private int maxSum;
        private int fromIndex;
        private int toIndex;
    }

}

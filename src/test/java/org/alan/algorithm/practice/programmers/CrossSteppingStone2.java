package org.alan.algorithm.practice.programmers;

public class CrossSteppingStone2 {
    public int solution(int[] stones, int k) {
        int result = 0;
        int min = 1;    // lowest stone
        int max = 200000000;    // highest stone

        while (min <= max) {
            int mid = (min + max) / 2;

            if (canCross(stones, k, mid)) {
                min = mid + 1;
                result = Math.max(result, mid);
            } else {
                max = mid - 1;
            }
        }
        return result;
    }

    private boolean canCross(int[] stones, int k, int mid) {
        int skip = 0;
        for (int stone : stones) {
            if (stone - mid < 0) {
                skip++;
            } else {
                skip = 0;
            }

            if (skip == k) {
                return false;
            }
        }
        return true;
    }
}

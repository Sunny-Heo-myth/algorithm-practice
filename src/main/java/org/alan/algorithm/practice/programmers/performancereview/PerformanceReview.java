package org.alan.algorithm.practice.programmers.performancereview;

import java.util.Arrays;

/**
 * idea 1: do core algorithm before sorting(merge sort which runs a lot faster than n log n when it is partially sorted, even run with n when it is nearly sorted. Space complexity will be n/2 at random element.)
 *         Sort with attitude first with descending order, ascending order with appraisal when attitude is equal.
 * idea 2:
 * idea 3:
 */
public class PerformanceReview {

    public int solution(int[][] scores) {
        int[] wanHo = scores[0];
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int answer = 1, maxAppraisalTilNow = 0, wanHoSum = wanHo[0] + wanHo[1];

        for (int[] score : scores) {
            int attitude = score[0];
            int appraisal = score[1];

            if (appraisal < maxAppraisalTilNow) {
                if (Arrays.equals(score, wanHo)) {
                    return -1;
                }
            } else {
                maxAppraisalTilNow = appraisal;
                if (attitude + appraisal > wanHoSum) {
                    answer++;
                }
            }
        }
        return answer;
    }



}

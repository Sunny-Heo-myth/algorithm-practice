package org.alan.algorithm.practice.programmers.performancereview;

import java.util.Arrays;

public class PerformanceReview2 {

    public int solution(int[][] scores) {
        int[] wanHo = scores[0];
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int rank = 1, maxAppraisalForNow = 0, sumOfWanHo = wanHo[0] + wanHo[1];
        for (int[] score : scores) {
            int attitude = score[0], appraisal = score[1];
            if (maxAppraisalForNow > appraisal) {
                if (Arrays.equals(score, wanHo)) {
                    return -1;
                }
            } else {
                maxAppraisalForNow = appraisal;
                if (attitude + appraisal > sumOfWanHo) {
                    rank++;
                }
            }
        }
        return rank;
    }
}

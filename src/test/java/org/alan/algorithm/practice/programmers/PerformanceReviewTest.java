package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.performancereview.PerformanceReview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerformanceReviewTest {

    @Test
    public void test1() {
        int[][] input = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        PerformanceReview instance = new PerformanceReview();
        Assertions.assertEquals(4, instance.solution(input));
    }

}

package org.alan.algorithm.practice.baekjoon.stepbystep.ifif;

import org.junit.jupiter.api.Test;

public class BJ2525Test {

    @Test
    void BJ2525_3Test() {
        // given
        BJ2525_3 sample = new BJ2525_3();

        BJ2525_3.Time time1 = new BJ2525_3.Time(14, 30);
        int elapsed1 = 20;

        BJ2525_3.Time time2 = new BJ2525_3.Time(17, 40);
        int elapsed2 = 80;

        BJ2525_3.Time time3 = new BJ2525_3.Time(23, 48);
        int elapsed3 = 25;

        // when
        BJ2525_3.Time result1 = sample.elapse(time1, elapsed1);
        BJ2525_3.Time result2 = sample.elapse(time2, elapsed2);
        BJ2525_3.Time result3 = sample.elapse(time3, elapsed3);

        // then
        System.out.println(result1.getHour() + " " + result1.getMinute());
        System.out.println(result2.getHour() + " " + result2.getMinute());
        System.out.println(result3.getHour() + " " + result3.getMinute());
    }
}

package org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ1269Test {

    @Test
    void test1() {
        String input = "3 5\n" +
                "1 2 4\n" +
                "2 3 4 5 6";
        long expected = 4;

        BJ1269 instance = new BJ1269(input);
        Assertions.assertEquals(expected, instance.answer());
    }
}

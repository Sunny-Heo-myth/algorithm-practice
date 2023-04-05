package org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ10816Test {

    @Test
    void test1() {
        String input = "10\n" +
                "6 3 2 10 10 10 -10 -10 7 3\n" +
                "8\n" +
                "10 9 -5 2 3 4 5 -10";
        BJ10816 instance = new BJ10816(input);

        Assertions.assertEquals("3 0 0 1 2 0 0 2", instance.answer());
    }
}

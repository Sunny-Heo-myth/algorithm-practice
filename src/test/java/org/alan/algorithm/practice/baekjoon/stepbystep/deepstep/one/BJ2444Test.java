package org.alan.algorithm.practice.baekjoon.stepbystep.deepstep.one;

import org.alan.algorithm.practice.baekjoon.stepbystep.deepstep.BJ2444;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ2444Test {

    @Test
    void test1() {
        int i = 5;
        String expected =
                "    *\n" +
                "   ***\n" +
                "  *****\n" +
                " *******\n" +
                "*********\n" +
                " *******\n" +
                "  *****\n" +
                "   ***\n" +
                "    *";
        BJ2444 instance = new BJ2444();

        // when
        String answer = instance.solve(i);

        // then
        assertEquals(expected, answer);
    }
}

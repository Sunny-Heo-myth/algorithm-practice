package org.alan.algorithm.practice.baekjoon.stepbystep.setmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ10815Test {
    @Test
    void test1() {
        String input =
                "5\n" +
                "6 3 2 10 -10\n" +
                "8\n" +
                "10 9 -5 2 3 4 5 -10";

        BJ10815 instance = new BJ10815(input);
        assertEquals(instance.answer(), "1 0 0 1 1 0 0 1");
    }
}

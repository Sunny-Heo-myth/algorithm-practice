package org.alan.algorithm.practice.baekjoon.stepbystep.recursionstep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ24060Test {

    @Test
    void test1() {
        String input =
                "5 7\n" +
                "4 5 1 3 2";

        BJ24060 instance = new BJ24060(input);
        assertEquals(instance.answer(), 3);
    }

    @Test
    void test2() {
        String input = "10 8\n" +
                "10 4 5 1 3 2 9 6 7 8";

        BJ24060 instance = new BJ24060(input);
        assertEquals(instance.answer(), 5);
    }
}

package org.alan.algorithm.practice.baekjoon.stepbystep.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ11382Test {

    @Test
    void test1() {
        String input = "77 77 7777";
        String expected = "7931";

        BJ11382 instance = new BJ11382(input);
        Assertions.assertEquals(expected, instance.answer());
    }
}

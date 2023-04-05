package org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ11478Test {

    @Test
    void test1() {
        String input = "ababc";
        int expected = 12;
        BJ11478 instance = new BJ11478(input);
        int n = instance.answer();
        Assertions.assertEquals(expected, n);
    }

    @Test
    void test2() {
        String input = "abcde";
        int expected = 15;
        BJ11478 instance = new BJ11478(input);
        int n = instance.answer();
        Assertions.assertEquals(expected, n);
    }
}

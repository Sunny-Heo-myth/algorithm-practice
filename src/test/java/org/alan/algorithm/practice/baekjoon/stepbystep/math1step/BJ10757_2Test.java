package org.alan.algorithm.practice.baekjoon.stepbystep.math1step;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ10757_2Test {
    @Test
    void test1() {
        String input = "9223372036854775807 9223372036854775808";
        String expected = "18446744073709551615";
        BJ10757_2 instance = new BJ10757_2(input);
        String answer = instance.answer();
        Assertions.assertEquals(expected, answer);
    }

    @Test
    void test2() {
        String input = "1 1";
        String expected = "2";
        BJ10757_2 instance = new BJ10757_2(input);
        String answer = instance.answer();
        Assertions.assertEquals(expected, answer);
    }
}

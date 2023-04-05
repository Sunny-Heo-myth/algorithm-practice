package org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ1764Test {

    @Test
    void test1() {
        String input = "3 4\n" +
                "ohhenrie\n" +
                "charlie\n" +
                "baesangwook\n" +
                "obama\n" +
                "baesangwook\n" +
                "ohhenrie\n" +
                "clinton";
        String expected = "2\n" +
                "baesangwook\n" +
                "ohhenrie";

        BJ1764 instance = new BJ1764(input);
        String answer = instance.answer();
        Assertions.assertEquals(expected, answer);
    }

    @Test
    void test2() {
        String input = "1 1\n" +
                "a\n" +
                "b\n";
        String expected = "0";

        BJ1764 instance = new BJ1764(input);
        String answer = instance.answer();
        Assertions.assertEquals(expected, answer);
    }
}

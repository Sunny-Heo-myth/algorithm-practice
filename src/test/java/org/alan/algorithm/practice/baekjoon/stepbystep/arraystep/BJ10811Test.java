package org.alan.algorithm.practice.baekjoon.stepbystep.arraystep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ10811Test {

    @Test
    void test1() {
        String input = "5 4\n" +
                "1 2\n" +
                "3 4\n" +
                "1 4\n" +
                "2 2";
        String expected = "3 4 1 2 5";

        BJ10811 instance = new BJ10811(input);
        Assertions.assertEquals(expected, instance.toString());
    }
}

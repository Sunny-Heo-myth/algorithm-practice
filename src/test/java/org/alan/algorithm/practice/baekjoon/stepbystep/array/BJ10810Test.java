package org.alan.algorithm.practice.baekjoon.stepbystep.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ10810Test {

    @Test
    void test1() {
        String input =
                "5 4\n" +
                "1 2 3\n" +
                "3 4 4\n" +
                "1 4 1\n" +
                "2 2 2";
        String expected = "1 2 1 1 0";

        BJ10810 instance = new BJ10810(input);
        Assertions.assertEquals(expected, instance.answer());
    }
}

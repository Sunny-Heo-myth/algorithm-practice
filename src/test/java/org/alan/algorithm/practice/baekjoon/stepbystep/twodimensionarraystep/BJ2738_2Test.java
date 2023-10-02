package org.alan.algorithm.practice.baekjoon.stepbystep.twodimensionarraystep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ2738_2Test {

    @Test
    public void test1() {
        String input = "3 3\n" +
                "1 1 1\n" +
                "2 2 2\n" +
                "0 1 0\n" +
                "3 3 3\n" +
                "4 4 4\n" +
                "5 5 100";

        String expected = "4 4 4\n" +
                "6 6 6\n" +
                "5 6 100";

        BJ2738_2 instance = new BJ2738_2(input);

        Assertions.assertEquals(expected, instance.answer());
    }
}

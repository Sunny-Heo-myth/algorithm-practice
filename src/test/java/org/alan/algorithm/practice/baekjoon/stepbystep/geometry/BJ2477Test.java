package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import org.alan.algorithm.practice.baekjoon.stepbystep.iostep.BJ2477;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ2477Test {

    @Test
    void test() {
        String input = "7\n" +
                "4 50\n" +
                "2 160\n" +
                "3 30\n" +
                "1 60\n" +
                "3 20\n" +
                "1 100";
        int expected = 47600;
        BJ2477 instance = new BJ2477(input);
        int answer = instance.answer();
        Assertions.assertEquals(expected, answer);

    }
}

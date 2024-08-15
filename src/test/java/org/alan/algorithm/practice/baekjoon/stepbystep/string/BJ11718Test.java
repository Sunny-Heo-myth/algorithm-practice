package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ11718Test {

    @Test
    void test1() {
        String input = "Hello\n" +
                "Baekjoon\n" +
                "Online Judge";

        BJ11718 instance = new BJ11718();
        String output = instance.solve(input);
        assertEquals(input, output);
    }
}

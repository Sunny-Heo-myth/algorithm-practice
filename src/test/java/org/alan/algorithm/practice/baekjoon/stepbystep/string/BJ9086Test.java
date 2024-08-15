package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ9086Test {

    @Test
    void test1() {
        // given
        String input = "ACDKJFOWIEGHE";
        BJ9086 instance = new BJ9086();

        // when
        String answer = instance.solve(input);

        // then
        assertEquals("AE", answer);

    }
}

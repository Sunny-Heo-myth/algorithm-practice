package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ2743Test {

    @Test
    void test1() {
        // given
        String input = "pulljima";
        BJ2743 instance = new BJ2743();

        // when
        int length = instance.solve(input);

        // then
        assertEquals(8, length);
    }
}

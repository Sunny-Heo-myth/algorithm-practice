package org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexity;

import org.alan.algorithm.practice.baekjoon.timecomplexity.BJ24266;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24266Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7", "343\n3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24266 instance = new BJ24266();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}

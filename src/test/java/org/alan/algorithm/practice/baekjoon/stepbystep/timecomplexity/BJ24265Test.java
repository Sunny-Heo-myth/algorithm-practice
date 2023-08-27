package org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexity;

import org.alan.algorithm.practice.baekjoon.timecomplexity.BJ24265;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24265Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7", "21\n2"),
                Arguments.of("500000", "124999750000\n2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24265 instance = new BJ24265();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}

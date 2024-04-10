package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1783Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("100 50", "48"),
                Arguments.of("1 1", "1"),
                Arguments.of("17 5", "4"),
                Arguments.of("2 4", "2"),
                Arguments.of("20 4", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1783().solve(input));
    }
}

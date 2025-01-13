package org.alan.algorithm.practice.baekjoon.stepbystep.divideconquer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11401Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 0", "1"),
                Arguments.of("1 1", "1"),
                Arguments.of("2 0", "1"),
                Arguments.of("2 1", "2"),
                Arguments.of("2 2", "1"),
                Arguments.of("200 0", "1"),
                Arguments.of("200 1", "200"),
                Arguments.of("200 2", "19900"),
                Arguments.of("5 2", "10"),
                Arguments.of("5 3", "10")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11401().solve(input));
    }
}

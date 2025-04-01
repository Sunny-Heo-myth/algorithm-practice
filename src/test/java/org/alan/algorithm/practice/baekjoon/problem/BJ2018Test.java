package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2018Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("2", "1"),
                Arguments.of("3", "2"),
                Arguments.of("4", "1"),
                Arguments.of("5", "2"),
                Arguments.of("15", "4"),
                Arguments.of("30", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2018(input).solve());
    }
}

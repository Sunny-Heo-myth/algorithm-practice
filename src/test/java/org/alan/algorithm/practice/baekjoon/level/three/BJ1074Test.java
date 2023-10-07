package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1074Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 0 0", "0"),
                Arguments.of("2 3 1", "11"),
                Arguments.of("3 7 7", "63"),
                Arguments.of("4 7 7", "63"),
                Arguments.of("10 511 511", "262143"),
                Arguments.of("10 512 512", "786432")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1074 instance = new BJ1074();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}

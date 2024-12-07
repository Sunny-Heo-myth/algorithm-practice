package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4375Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3", "3"),
                Arguments.of("7", "6"),
                Arguments.of("9901", "12")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ4375().solve(input));
    }
}

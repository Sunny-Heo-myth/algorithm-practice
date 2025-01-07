package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1699Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("2", "2"),
                Arguments.of("3", "3"),
                Arguments.of("4", "1"),
                Arguments.of("5", "2"),
                Arguments.of("6", "3"),
                Arguments.of("7", "4"),
                Arguments.of("8", "2"),
                Arguments.of("9", "1"),
                Arguments.of("10", "2"),
                Arguments.of("11", "3"),
                Arguments.of("12", "3"),
                Arguments.of("13", "2"),
                Arguments.of("32", "2"),
                Arguments.of("100", "1"),
                Arguments.of("121", "1"),
                Arguments.of("10000", "1"),
                Arguments.of("100000", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1699().solve(input));
    }
}

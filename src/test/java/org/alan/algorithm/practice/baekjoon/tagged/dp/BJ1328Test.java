package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1328Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("3 2 2", "2"),
                Arguments.of("3 2 1", "1"),
                Arguments.of("5 3 2", "18"),
                Arguments.of("12 1 1", "0"),
                Arguments.of("8 3 2", "4872")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1328(input).solve());
    }
}

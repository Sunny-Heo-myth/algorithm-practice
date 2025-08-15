package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ10844Test {

    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("1", "9"),
                Arguments.of("2", "17"),
                Arguments.of("3", "32"),
                Arguments.of("4", "61")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10844(input).solve());
    }

}
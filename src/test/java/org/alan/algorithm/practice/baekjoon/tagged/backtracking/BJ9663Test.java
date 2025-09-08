package org.alan.algorithm.practice.baekjoon.tagged.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ9663Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("2", "0"),
                Arguments.of("3", "0"),
                Arguments.of("4", "2"),
                Arguments.of("8", "92")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9663(input).solve());
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9663_2(input).solve());
    }

}
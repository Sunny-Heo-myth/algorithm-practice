package org.alan.algorithm.practice.baekjoon.tagged.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ2230Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        3 3
                        1
                        5
                        3""", "4"),
                Arguments.of("""
                        5 3
                        1
                        5
                        2
                        3
                        4""", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2230(input).solve());
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2230_2(input).solve());
    }

}
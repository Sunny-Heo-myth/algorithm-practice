package org.alan.algorithm.practice.baekjoon.tagged.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ11652Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        5
                        1
                        2
                        1
                        2
                        1""", "1"),
                Arguments.of("""
                        6
                        1
                        2
                        1
                        2
                        1
                        2""", "1"),
                Arguments.of("""
                        1
                        1""", "1"),
                Arguments.of("""
                        5
                        -1
                        0
                        1
                        0
                        -1""", "-1")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11652(input).solve());
    }

}
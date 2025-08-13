package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ7576Test {

    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        6 4
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 1""", "8"),
                Arguments.of("""
                        6 4
                        0 -1 0 0 0 0
                        -1 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 1""", "-1"),
                Arguments.of("""
                        6 4
                        1 -1 0 0 0 0
                        0 -1 0 0 0 0
                        0 0 0 0 -1 0
                        0 0 0 0 -1 1""", "6"),
                Arguments.of("""
                        5 5
                        -1 1 0 0 0
                        0 -1 -1 -1 0
                        0 -1 -1 -1 0
                        0 -1 -1 -1 0
                        0 0 0 0 0""", "14"),
                Arguments.of("""
                        2 2
                        1 -1
                        -1 1""", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ7576(input).solve());
    }

}
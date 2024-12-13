package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1600Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        1 1
                        0""", "0"),
                Arguments.of("""
                        0
                        1 1
                        0""", "0"),
                Arguments.of("""
                        0
                        2 2
                        0 0
                        0 0""", "2"),
                Arguments.of("""
                        1
                        2 2
                        0 0
                        0 0""", "2"),
                Arguments.of("""
                        0
                        3 3
                        0 0 0
                        0 0 0
                        0 0 0""", "4"),
                Arguments.of("""
                        0
                        3 3
                        0 0 1
                        0 1 0
                        1 0 0""", "-1"),
                Arguments.of("""
                        1
                        3 3
                        0 0 0
                        0 0 0
                        0 0 0""", "2"),
                Arguments.of("""
                        2
                        3 3
                        0 0 0
                        0 0 0
                        0 0 0""", "2"),
                Arguments.of("""
                        1
                        4 4
                        0 0 0 0
                        1 0 0 0
                        0 0 1 0
                        0 1 0 0""", "4"),
                Arguments.of("""
                        2
                        5 2
                        0 0 1 1 0
                        0 0 1 1 0""", "-1"),
                Arguments.of("""
                        2
                        6 6
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0""", "-1"),
                Arguments.of("""
                        2
                        6 6
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 0 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0""", "6"),
                Arguments.of("""
                        3
                        6 6
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 0 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0""", "4"),
                Arguments.of("""
                        1
                        6 6
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 0 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0
                        0 0 1 1 0 0""", "8"),
                Arguments.of("""
                        4
                        7 8
                        0 0 1 0 0 0 0
                        1 1 1 0 0 0 0
                        1 1 1 1 1 1 1
                        0 0 1 1 1 1 0
                        0 0 0 0 0 1 1
                        0 1 1 1 1 1 1
                        1 1 1 1 1 1 1
                        1 0 0 0 0 0 0""", "17")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1600().solve(input));
    }
}

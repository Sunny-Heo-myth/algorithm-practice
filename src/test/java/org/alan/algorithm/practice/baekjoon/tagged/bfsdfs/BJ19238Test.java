package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ19238Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        6 3 15
                        0 0 1 0 0 0
                        0 0 1 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 1 0
                        0 0 0 1 0 0
                        6 5
                        2 2 5 6
                        5 4 1 6
                        4 2 3 5""", "14"),
                Arguments.of("""
                        6 3 13
                        0 0 1 0 0 0
                        0 0 1 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 1 0
                        0 0 0 1 0 0
                        6 5
                        2 2 5 6
                        5 4 1 6
                        4 2 3 5""", "-1"),
                Arguments.of("""
                        6 3 100
                        0 0 1 0 0 0
                        0 0 1 0 0 0
                        0 0 0 1 0 0
                        0 0 0 1 0 0
                        0 0 0 0 1 0
                        0 0 0 1 0 0
                        6 5
                        2 2 5 6
                        5 4 1 6
                        4 2 3 5""", "-1"),
                Arguments.of("""
                        3 1 2
                        0 0 0
                        0 0 0
                        0 0 0
                        1 1
                        1 3 3 1""", "-1"),
                Arguments.of("""
                        5 2 20
                        0 1 1 1 0
                        0 0 0 0 0
                        0 1 0 1 0
                        0 1 0 1 1
                        0 1 0 0 0
                        4 3
                        2 1 5 1
                        2 5 3 5""", "13"),
                Arguments.of("""
                        10 1 5000
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        5 5
                        10 10 5 5""", "5000"),
                Arguments.of("""
                        6 1 2
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        3 4
                        3 4 2 5""", "4"),
                Arguments.of("""
                        6 1 19
                        1 0 0 0 1 0
                        1 0 1 0 1 1
                        1 0 1 0 1 0
                        1 0 1 0 1 0
                        1 0 1 0 1 0
                        0 0 1 0 0 0
                        1 3
                        4 2 1 6""", "-1"),
                Arguments.of("""
                        6 1 500000
                        1 0 0 0 1 0
                        1 0 1 0 1 1
                        1 0 1 0 1 0
                        1 0 1 0 1 0
                        1 0 1 0 1 0
                        0 0 1 0 0 0
                        1 3
                        4 2 1 6""", "-1")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ19238(input).solve());
    }
}

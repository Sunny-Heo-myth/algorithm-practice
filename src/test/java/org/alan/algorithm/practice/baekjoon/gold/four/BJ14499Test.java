package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ14499Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 2 0 0 8
                        0 2
                        3 4
                        5 6
                        7 8
                        4 4 4 1 3 3 3 2""", """
                        0
                        0
                        3
                        0
                        0
                        8
                        6
                        3"""),
                Arguments.of("""
                        3 3 1 1 9
                        1 2 3
                        4 0 5
                        6 7 8
                        1 3 2 2 4 4 1 1 3""", """
                        0
                        0
                        0
                        3
                        0
                        1
                        0
                        6
                        0"""),
                Arguments.of("""
                        2 2 0 0 16
                        0 2
                        3 4
                        4 4 4 4 1 1 1 1 3 3 3 3 2 2 2 2""", """
                        0
                        0
                        0
                        0"""),
                Arguments.of("""
                        3 3 0 0 16
                        0 1 2
                        3 4 5
                        6 7 8
                        4 4 1 1 3 3 2 2 4 4 1 1 3 3 2 2""", """
                        0
                        0
                        0
                        6
                        0
                        8
                        0
                        2
                        0
                        8
                        0
                        2
                        0
                        8
                        0
                        2""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ14499().solve(input));
    }
}

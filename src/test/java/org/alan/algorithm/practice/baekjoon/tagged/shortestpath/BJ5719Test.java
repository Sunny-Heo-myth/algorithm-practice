package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5719Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        7 9
                        0 6
                        0 1 1
                        0 2 1
                        0 3 2
                        0 4 3
                        1 5 2
                        2 6 4
                        3 6 2
                        4 6 4
                        5 6 1""", "5"),
                Arguments.of("""
                        4 6
                        0 2
                        0 1 1
                        1 2 1
                        1 3 1
                        3 2 1
                        2 0 3
                        3 0 2""", "-1"),
                Arguments.of("""
                        6 8
                        0 1
                        0 1 1
                        0 2 2
                        0 3 3
                        2 5 3
                        3 4 2
                        4 1 1
                        5 1 1
                        3 0 1""", "6")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ5719(input).solve());
    }
}

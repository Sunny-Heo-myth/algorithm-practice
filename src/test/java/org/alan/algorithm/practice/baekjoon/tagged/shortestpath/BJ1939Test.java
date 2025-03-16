package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1939Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        2 1
                        1 2 2
                        1 2""", "2"),
                Arguments.of("""
                        2 3
                        1 2 2
                        1 2 3
                        1 2 4
                        1 2""", "4"),
                Arguments.of("""
                        3 3
                        1 2 2
                        3 1 3
                        2 3 2
                        1 3""", "3"),
                Arguments.of("""
                        5 6
                        1 2 2
                        3 1 3
                        2 3 2
                        2 4 2
                        3 4 1
                        4 5 2
                        1 5""", "2"),
                Arguments.of("""
                        5 8
                        1 2 2
                        3 1 3
                        2 3 2
                        2 5 5
                        3 5 4
                        1 4 4
                        3 4 4
                        4 5 2
                        1 5""", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1939(input).solve());
    }
}

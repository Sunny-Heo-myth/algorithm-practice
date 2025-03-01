package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17142Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        7 3
                        2 0 0 0 1 1 0
                        0 0 1 0 1 2 0
                        0 1 1 0 1 0 0
                        0 1 0 0 0 0 0
                        0 0 0 2 0 1 1
                        0 1 0 0 0 0 0
                        2 1 0 0 0 0 2""", "4"),
                Arguments.of("""
                        7 3
                        2 0 2 0 1 1 0
                        0 0 1 0 1 2 0
                        0 1 1 2 1 0 0
                        2 1 0 0 0 0 2
                        0 0 0 2 0 1 1
                        0 1 0 0 0 0 0
                        2 1 0 0 2 0 2""", "4"),
                Arguments.of("""
                        7 4
                        2 0 2 0 1 1 0
                        0 0 1 0 1 2 0
                        0 1 1 2 1 0 0
                        2 1 0 0 0 0 2
                        0 0 0 2 0 1 1
                        0 1 0 0 0 0 0
                        2 1 0 0 2 0 2""", "4"),
                Arguments.of("""
                        7 5
                        2 0 2 0 1 1 0
                        0 0 1 0 1 2 0
                        0 1 1 2 1 0 0
                        2 1 0 0 0 0 2
                        0 0 0 2 0 1 1
                        0 1 0 0 0 0 0
                        2 1 0 0 2 0 2""", "3"),
                Arguments.of("""
                        7 3
                        2 0 2 0 1 1 0
                        0 0 1 0 1 0 0
                        0 1 1 1 1 0 0
                        2 1 0 0 0 0 2
                        1 0 0 0 0 1 1
                        0 1 0 0 0 0 0
                        2 1 0 0 2 0 2""", "7"),
                Arguments.of("""
                        7 2
                        2 0 2 0 1 1 0
                        0 0 1 0 1 0 0
                        0 1 1 1 1 0 0
                        2 1 0 0 0 0 2
                        1 0 0 0 0 1 1
                        0 1 0 0 0 0 0
                        2 1 0 0 2 0 2""", "-1"),
                Arguments.of("""
                        5 1
                        2 2 2 1 1
                        2 1 1 1 1
                        2 1 1 1 1
                        2 1 1 1 1
                        2 2 2 1 1""", "0"),
                Arguments.of("""
                        4 1
                        2 2 2 1
                        2 1 2 1
                        2 1 2 1
                        2 1 1 1""", "0"),
                Arguments.of("""
                        5 2
                        0 0 0 2 2
                        1 1 1 1 0
                        2 1 2 1 0
                        2 1 1 1 1
                        2 2 2 2 0""", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17142().solve(input));
    }
}

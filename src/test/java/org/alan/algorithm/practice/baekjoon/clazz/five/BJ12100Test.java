package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ12100Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3
                        2 2 2
                        4 4 4
                        8 8 8""", "16"),
                Arguments.of("""
                        5
                        0 0 0 0 0
                        4 4 4 4 0
                        4 4 4 4 0
                        4 4 4 4 0
                        4 4 4 4 0""", "64"),
                Arguments.of("""
                        1
                        2""", "2"),
                Arguments.of("""
                        2
                        2 0
                        0 2""", "4"),
                Arguments.of("""
                        2
                        2 2
                        0 2""", "4"),
                Arguments.of("""
                        3
                        2 0 2
                        0 0 0
                        4 0 4""", "8"),
                Arguments.of("""
                        3
                        4 0 4
                        0 0 0
                        4 0 4""", "16"),
                Arguments.of("""
                        4
                        4 4 4 4
                        0 4 2 2
                        4 0 4 0
                        0 0 0 0""", "32")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ12100().solve(input));
    }
}

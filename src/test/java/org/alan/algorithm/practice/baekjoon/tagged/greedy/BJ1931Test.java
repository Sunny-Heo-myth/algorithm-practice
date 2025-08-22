package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1931Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        0 1
                        2 2
                        1 2
                        0 2
                        2 3""", "4"),
                Arguments.of("""
                        5
                        0 0
                        0 1
                        0 0
                        0 2
                        1 2""", "4"),
                Arguments.of("""
                        3
                        0 0
                        0 0
                        0 0""", "3"),
                Arguments.of("""
                        11
                        1 4
                        3 5
                        0 6
                        5 7
                        3 8
                        5 9
                        6 10
                        8 11
                        8 12
                        2 13
                        12 14""", "4"),
                Arguments.of("""
                        13
                        3 5
                        0 6
                        5 7
                        3 8
                        5 9
                        6 10
                        3 4
                        2 4
                        12 14
                        1 4
                        8 11
                        8 12
                        2 13""", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1931(input).solve());
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1931_2(input).solve());
    }
}

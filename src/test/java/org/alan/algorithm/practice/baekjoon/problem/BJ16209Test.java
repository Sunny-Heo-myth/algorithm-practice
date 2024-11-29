package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16209Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        7 7 12 14""", "7 12 14 7"),
                Arguments.of("""
                        4
                        1 2 3 4""", "1 3 4 2"),
                Arguments.of("""
                        2
                        1 1""", "1 1"),
                Arguments.of("""
                        4
                        -1 -2 1 2""", "-2 -1 1 2"),
                Arguments.of("""
                        8
                        -4 -3 -2 -1 1 2 3 4""", "-2 -4 -3 -1 1 3 4 2"),
                Arguments.of("""
                        5
                        -2 -1 0 2 3""", "-2 -1 0 2 3"),
                Arguments.of("""
                        5
                        -1 -1 0 1 1""", "-1 -1 0 1 1"),
                Arguments.of("""
                        5
                        -1 0 0 0 1""", "-1 0 0 0 1"),
                Arguments.of("""
                        5
                        -1 0 1 0 1""", "-1 0 1 1 0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16209().solve(input));
    }

}

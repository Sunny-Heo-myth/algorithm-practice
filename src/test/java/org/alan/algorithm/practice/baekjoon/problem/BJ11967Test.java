package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11967Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 0""", "1"),
                Arguments.of("""
                        2 1
                        1 1 1 2""", "2"),
                Arguments.of("""
                        2 1
                        1 1 2 2""", "2"),
                Arguments.of("""
                        2 1
                        2 2 1 2""", "1"),
                Arguments.of("""
                        2 1
                        2 2 1 1""", "1"),
                Arguments.of("""
                        2 2
                        1 1 1 2
                        1 1 2 2""", "3"),
                Arguments.of("""
                        2 2
                        1 1 1 2
                        1 2 2 2""", "3"),
                Arguments.of("""
                        3 6
                        1 1 1 2
                        2 1 2 2
                        1 1 1 3
                        2 3 3 1
                        1 3 1 2
                        1 3 2 1""", "5")

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11967().solve(input));
    }
}

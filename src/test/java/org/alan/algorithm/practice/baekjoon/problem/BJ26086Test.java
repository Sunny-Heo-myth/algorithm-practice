package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ26086Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 5 3
                        0 1
                        0 2
                        2
                        2
                        0 4""", "1"),
                Arguments.of("""
                        5 5 3
                        0 1
                        0 2
                        1
                        1
                        0 4""", "2"),
                Arguments.of("""
                        5 7 5
                        0 1
                        0 2
                        0 3
                        1
                        0 4
                        0 5
                        2""", "5"),
                Arguments.of("""
                        5 6 2
                        0 1
                        0 2
                        0 3
                        0 4
                        0 5
                        2""", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ26086().solve(input));
    }
}

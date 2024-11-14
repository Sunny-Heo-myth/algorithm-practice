package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17299Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        100""", "-1"),
                Arguments.of("""
                        7
                        1 1 2 3 4 2 1""", "-1 -1 1 2 2 1 -1"),
                Arguments.of("""
                        7
                        1 1 1 1 1 1 1""", "-1 -1 -1 -1 -1 -1 -1"),
                Arguments.of("""
                        10
                        8 1 2 2 4 3 7 8 4 1""", "-1 -1 -1 -1 -1 8 8 -1 -1 -1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17299().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2110Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 3
                        1
                        2
                        8
                        4
                        9""", "3"),
                Arguments.of("""
                        5 4
                        1
                        2
                        4
                        8
                        9""", "1"),
                Arguments.of("""
                        6 2
                        1
                        2
                        3
                        4
                        5
                        6""", "5"),
                Arguments.of("""
                        7 4
                        1
                        5
                        7
                        9
                        100
                        103
                        200""", "8"),
                Arguments.of("""
                        9 4
                        1
                        5
                        17
                        50
                        52
                        90
                        121
                        126
                        132""", "40")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2110().solve(input));
    }
}

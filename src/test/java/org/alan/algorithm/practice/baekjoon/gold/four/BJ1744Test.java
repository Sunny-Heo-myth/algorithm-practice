package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1744Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        -1
                        2
                        1
                        3""", "6"),
                Arguments.of("""
                        6
                        0
                        1
                        2
                        4
                        3
                        5""", "27"),
                Arguments.of("""
                        1
                        -1""", "-1"),
                Arguments.of("""
                        3
                        -1
                        0
                        1""", "1"),
                Arguments.of("""
                        2
                        1
                        1""", "2"),
                Arguments.of("""
                        2
                        -1
                        1""", "0"),
                Arguments.of("""
                        3
                        -3
                        -1
                        -1
                        0""", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1744().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1744().solve2(input));
    }
}

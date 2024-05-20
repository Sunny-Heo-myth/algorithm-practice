package org.alan.algorithm.practice.baekjoon.gold.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2294Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 15
                        1
                        5
                        12""", "3"),
                Arguments.of("""
                        3 10
                        1
                        2
                        3""", "4"),
                Arguments.of("""
                        1 2
                        3""", "-1"),
                Arguments.of("""
                        5 101
                        1
                        9
                        27
                        25
                        20""", "4"),
                Arguments.of("""
                        3 10
                        2
                        5
                        7""", "2"),
                Arguments.of("""
                        3 10
                        4
                        4
                        7""", "-1"),
                Arguments.of("""
                        5 10
                        1
                        2
                        4
                        7
                        9""", "2"),
                Arguments.of("""
                        6 20
                        1
                        3
                        4
                        4
                        13
                        9""", "3"),
                Arguments.of("""
                        3 10
                        1
                        2
                        7""", "3"),
                Arguments.of("""
                        6 10
                        1
                        1
                        1
                        2
                        2
                        7""", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2294().solve2(input));
    }
}

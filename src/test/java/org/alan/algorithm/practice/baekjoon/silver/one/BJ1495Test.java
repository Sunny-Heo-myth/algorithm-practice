package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1495Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 5 10
                        5 3 7""", "10"),
                Arguments.of("""
                        4 8 20
                        15 2 9 10""", "-1"),
                Arguments.of("""
                        14 40 243
                        74 39 127 95 63 140 99 96 154 18 137 162 14 88""", "238"),
                Arguments.of("""
                        1 0 1
                        1""", "1"),
                Arguments.of("""
                        1 1 1
                        1""", "0"),
                Arguments.of("""
                        1 999 1000
                        1""", "1000"),
                Arguments.of("""
                        1 1000 1000
                        1""", "999")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1495().solve(input));
    }
}

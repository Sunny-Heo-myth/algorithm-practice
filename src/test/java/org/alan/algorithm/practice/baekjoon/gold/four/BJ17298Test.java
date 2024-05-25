package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17298Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        10""", "-1"),
                Arguments.of("""
                        1
                        9 10""", "10 -1"),
                Arguments.of("""
                        4
                        3 5 2 7""", "5 7 7 -1"),
                Arguments.of("""
                        4
                        9 5 4 8""", "-1 8 8 -1"),
                Arguments.of("""
                        10
                        12 9 6 8 3 2 9 7 4 11""", "-1 11 8 9 9 9 11 11 11 -1"),
                Arguments.of("""
                        10
                        10 9 8 7 6 5 4 3 2 1""", "-1 -1 -1 -1 -1 -1 -1 -1 -1 -1"),
                Arguments.of("""
                        10
                        1 1 1 1 1 1 1 1 1 1""", "-1 -1 -1 -1 -1 -1 -1 -1 -1 -1"),
                Arguments.of("""
                        10
                        1 2 3 4 5 6 7 8 9 10""", "2 3 4 5 6 7 8 9 10 -1"),
                Arguments.of("""
                        10
                        1 1 1 1 1 5 1 1 1 1""", "5 5 5 5 5 -1 -1 -1 -1 -1"),
                Arguments.of("""
                        10
                        1 1 1 1 1 5 1 1 1 1""", "5 5 5 5 5 -1 -1 -1 -1 -1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17298().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1976Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3
                        3
                        0 1 0
                        1 0 1
                        0 1 0
                        1 2 3""", "YES"),
                Arguments.of("""
                        3
                        3
                        0 1 0
                        1 0 0
                        0 0 0
                        1 2 3""", "NO"),
                Arguments.of("""
                        4
                        4
                        0 1 1 1
                        1 0 0 0
                        1 0 0 0
                        1 0 0 0
                        1 2 3 4""", "YES"),
                Arguments.of("""
                        4
                        4
                        0 1 1 0
                        1 0 0 0
                        1 0 0 0
                        0 0 0 0
                        1 2 3 4""", "NO")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1976().solve(input));
    }
}

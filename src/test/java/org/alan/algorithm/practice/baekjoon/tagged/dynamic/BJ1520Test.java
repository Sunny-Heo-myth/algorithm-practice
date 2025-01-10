package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1520Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 1
                        1""", "1"),
                Arguments.of("""
                        2 2
                        4 3
                        2 1""", "2"),
                Arguments.of("""
                        2 2
                        1 2
                        3 4""", "0"),
                Arguments.of("""
                        4 5
                        50 45 37 32 30
                        35 50 40 20 25
                        30 30 25 17 28
                        27 24 22 15 10""", "3")

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1520().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17386Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 1 5 5
                        1 5 5 1""", "1"),
                Arguments.of("""
                        1 1 5 5
                        6 10 10 6""", "0"),
                Arguments.of("""
                        1 1 5 5
                        2 2 4 4""", "0"),
                Arguments.of("""
                        1 3 4 16
                        9 11 12 24""", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17386().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17386().solve2(input));
    }
}

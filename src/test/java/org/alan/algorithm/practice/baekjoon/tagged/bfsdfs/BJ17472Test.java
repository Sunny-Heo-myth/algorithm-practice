package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17472Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        1 3
                        1 0 1""", "-1"),
                Arguments.of("""
                        1 4
                        1 0 0 1""", "2"),
                Arguments.of("""
                        1 4
                        1 1 0 1""", "-1"),
                Arguments.of("""
                        7 8
                        0 0 0 0 0 0 1 1
                        1 1 0 0 0 0 1 1
                        1 1 0 0 0 0 0 0
                        1 1 0 0 0 1 1 0
                        0 0 0 0 0 1 1 0
                        0 0 0 0 0 0 0 0
                        1 1 1 1 1 1 1 1""", "9"),
                Arguments.of("""
                        7 8
                        0 0 0 1 1 0 0 0
                        0 0 0 1 1 0 0 0
                        1 1 0 0 0 0 1 1
                        1 1 0 0 0 0 1 1
                        1 1 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0
                        1 1 1 1 1 1 1 1""", "10"),
                Arguments.of("""
                        7 8
                        1 0 0 1 1 1 0 0
                        0 0 1 0 0 0 1 1
                        0 0 1 0 0 0 1 1
                        0 0 1 1 1 0 0 0
                        0 0 0 0 0 0 0 0
                        0 1 1 1 0 0 0 0
                        1 1 1 1 1 1 0 0""", "9"),
                Arguments.of("""
                        7 7
                        1 1 1 0 1 1 1
                        1 1 1 0 1 1 1
                        1 1 1 0 1 1 1
                        0 0 0 0 0 0 0
                        1 1 1 0 1 1 1
                        1 1 1 0 1 1 1
                        1 1 1 0 1 1 1""", "-1")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17472(input).solve());
    }
}

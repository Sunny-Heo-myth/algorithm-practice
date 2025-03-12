package org.alan.algorithm.practice.baekjoon.tagged.bt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17136Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0""", "0"),
                Arguments.of("""
                        0 0 0 0 0 0 0 0 0 0
                        0 1 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 1 0 0 0 0 0
                        0 0 0 0 0 1 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 1 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0""", "4"),
                Arguments.of("""
                        0 0 0 0 0 0 0 0 0 0
                        0 1 1 0 0 0 0 0 0 0
                        0 0 1 0 0 0 0 0 0 0
                        0 0 0 0 1 1 0 0 0 0
                        0 0 0 0 1 1 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 1 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0""", "5"),
                Arguments.of("""
                        0 0 0 0 0 0 0 0 0 0
                        0 1 1 0 0 0 0 0 0 0
                        0 0 1 0 0 0 0 0 0 0
                        0 0 0 0 1 1 0 0 0 0
                        0 0 0 0 0 1 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 1 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0""", "-1"),
                Arguments.of("""
                        0 0 0 0 0 0 0 0 0 0
                        0 1 1 0 0 0 0 0 0 0
                        0 1 1 1 0 0 0 0 0 0
                        0 0 1 1 1 1 1 0 0 0
                        0 0 0 1 1 1 1 0 0 0
                        0 0 0 0 1 1 1 0 0 0
                        0 0 1 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0""", "7"),
                Arguments.of("""
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 1 1 1 1 1""", "4"),
                Arguments.of("""
                        0 0 0 0 0 0 0 0 0 0
                        0 1 1 1 1 1 0 0 0 0
                        0 1 1 1 1 1 0 0 0 0
                        0 0 1 1 1 1 0 0 0 0
                        0 0 1 1 1 1 0 0 0 0
                        0 1 1 1 1 1 1 1 1 1
                        0 1 1 1 0 1 1 1 1 1
                        0 1 1 1 0 1 1 1 1 1
                        0 0 0 0 0 1 1 1 1 1
                        0 0 0 0 0 1 1 1 1 1""", "6"),
                Arguments.of("""
                        0 0 0 0 0 0 0 0 0 0
                        1 1 1 1 1 0 0 0 0 0
                        1 1 1 1 1 0 1 1 1 1
                        1 1 1 1 1 0 1 1 1 1
                        1 1 1 1 1 0 1 1 1 1
                        1 1 1 1 1 0 1 1 1 1
                        0 0 0 0 0 0 0 0 0 0
                        0 1 1 1 0 1 1 0 0 0
                        0 1 1 1 0 1 1 0 0 0
                        0 1 1 1 0 0 0 0 0 1""", "5")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17136(input).solve());
    }
}

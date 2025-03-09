package org.alan.algorithm.practice.baekjoon.tagged.bt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15683Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        4 6
                        0 0 0 0 0 0
                        0 0 0 0 0 0
                        0 0 1 0 6 0
                        0 0 0 0 0 0""", "20"),
                Arguments.of("""
                        6 6
                        0 0 0 0 0 0
                        0 2 0 0 0 0
                        0 0 0 0 6 0
                        0 6 0 0 2 0
                        0 0 0 0 0 0
                        0 0 0 0 0 5""", "15"),
                Arguments.of("""
                        6 6
                        1 0 0 0 0 0
                        0 1 0 0 0 0
                        0 0 1 0 0 0
                        0 0 0 1 0 0
                        0 0 0 0 1 0
                        0 0 0 0 0 1""", "6"),
                Arguments.of("""
                        6 6
                        1 0 0 0 0 0
                        0 1 0 0 0 0
                        0 0 1 5 0 0
                        0 0 5 1 0 0
                        0 0 0 0 1 0
                        0 0 0 0 0 1""", "2"),
                Arguments.of("""
                        1 7
                        0 1 2 3 4 5 6""", "0"),
                Arguments.of("""
                        3 7
                        4 0 0 0 0 0 0
                        0 0 0 2 0 0 0
                        0 0 0 0 0 0 4""", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15683(input).solve());
    }
}

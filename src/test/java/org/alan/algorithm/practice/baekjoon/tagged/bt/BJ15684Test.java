package org.alan.algorithm.practice.baekjoon.tagged.bt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15684Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        2 0 3""", "0"),
                Arguments.of("""
                        2 1 3
                        1 1""", "1"),
                Arguments.of("""
                        5 5 6
                        1 1
                        3 2
                        2 3
                        5 1
                        5 4""", "3"),
                Arguments.of("""
                        6 5 6
                        1 1
                        3 2
                        1 3
                        2 5
                        5 5""", "3"),
                Arguments.of("""
                        5 8 6
                        1 1
                        2 2
                        3 3
                        4 4
                        3 1
                        4 2
                        5 3
                        6 4""", "-1"),
                Arguments.of("""
                        5 12 6
                        1 1
                        1 3
                        2 2
                        2 4
                        3 1
                        3 3
                        4 2
                        4 4
                        5 1
                        5 3
                        6 2
                        6 4""", "-1"),
                Arguments.of("""
                        5 6 6
                        1 1
                        3 1
                        5 2
                        4 3
                        2 3
                        1 4""", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15684(input).solve());
    }
}

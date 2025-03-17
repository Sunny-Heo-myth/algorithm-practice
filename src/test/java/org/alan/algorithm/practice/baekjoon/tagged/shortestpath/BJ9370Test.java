package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9370Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        5 4 2
                        1 2 3
                        1 2 6
                        2 3 2
                        3 4 4
                        3 5 3
                        5
                        4""", "4 5"),
                Arguments.of("""
                        6 9 2
                        2 3 1
                        1 2 1
                        1 3 3
                        2 4 4
                        2 5 5
                        3 4 3
                        3 6 2
                        4 5 4
                        4 6 3
                        5 6 7
                        5
                        6""", "6")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9370(input).solve());
    }
}

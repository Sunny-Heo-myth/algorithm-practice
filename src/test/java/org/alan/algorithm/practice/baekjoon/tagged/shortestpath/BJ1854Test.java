package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1854Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        5 10 2
                        1 2 2
                        1 3 7
                        1 4 5
                        1 5 6
                        2 4 2
                        2 3 4
                        3 4 6
                        3 5 8
                        5 2 4
                        5 4 1""", """
                        -1
                        10
                        7
                        5
                        14"""),
                Arguments.of("""
                        4 4 2
                        1 2 1
                        2 4 3
                        1 3 3
                        3 4 1""", """
                        -1
                        -1
                        -1
                        4""")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1854(input).solve());
    }
}

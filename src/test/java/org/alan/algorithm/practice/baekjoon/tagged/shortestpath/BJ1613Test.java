package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1613Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        5 5
                        1 2
                        1 3
                        2 3
                        3 4
                        2 4
                        3
                        1 5
                        2 4
                        3 1""", """
                        0
                        -1
                        1""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1613(input).solve());
    }
}

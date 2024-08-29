package org.alan.algorithm.practice.baekjoon.tagged.divideconquer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1780Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        9
                        0 0 0 1 1 1 -1 -1 -1
                        0 0 0 1 1 1 -1 -1 -1
                        0 0 0 1 1 1 -1 -1 -1
                        1 1 1 0 0 0 0 0 0
                        1 1 1 0 0 0 0 0 0
                        1 1 1 0 0 0 0 0 0
                        0 1 -1 0 1 -1 0 1 -1
                        0 -1 1 0 1 -1 0 1 -1
                        0 1 -1 1 0 -1 0 1 -1""", """
                        10
                        12
                        11""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1780().solve(input));
    }
}

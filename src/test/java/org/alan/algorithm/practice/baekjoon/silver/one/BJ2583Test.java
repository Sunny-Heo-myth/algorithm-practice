package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2583Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 7 3
                        0 2 4 4
                        1 1 2 5
                        4 0 6 2""", """
                        3
                        1 7 13""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2583().solve(input));
    }
}

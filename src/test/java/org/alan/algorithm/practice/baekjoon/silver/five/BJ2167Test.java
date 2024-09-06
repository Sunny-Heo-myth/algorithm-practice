package org.alan.algorithm.practice.baekjoon.silver.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2167Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2 3
                        1 2 4
                        8 16 32
                        3
                        1 1 2 3
                        1 2 1 2
                        1 3 2 3""", """
                        63
                        2
                        36""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2167().solve(input));
    }
}

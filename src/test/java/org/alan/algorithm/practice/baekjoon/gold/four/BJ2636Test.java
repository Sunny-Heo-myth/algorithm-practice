package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2636Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        13 12
                        0 0 0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 0 0 0 1 1 0 0 0
                        0 1 1 1 0 0 0 1 1 0 0 0
                        0 1 1 1 1 1 1 0 0 0 0 0
                        0 1 1 1 1 1 0 1 1 0 0 0
                        0 1 1 1 1 0 0 1 1 0 0 0
                        0 0 1 1 0 0 0 1 1 0 0 0
                        0 0 1 1 1 1 1 1 1 0 0 0
                        0 0 1 1 1 1 1 1 1 0 0 0
                        0 0 1 1 1 1 1 1 1 0 0 0
                        0 0 1 1 1 1 1 1 1 0 0 0
                        0 0 0 0 0 0 0 0 0 0 0 0""", """
                        3
                        5""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2636().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2822Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        20
                        30
                        50
                        48
                        33
                        66
                        0
                        64""", """
                        261
                        3 4 5 6 8""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2822().solve(input));
    }
}

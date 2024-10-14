package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2309Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        20
                        7
                        23
                        19
                        10
                        15
                        25
                        8
                        13""", """
                        7
                        8
                        10
                        13
                        19
                        20
                        23""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2309().solve(input));
    }
}

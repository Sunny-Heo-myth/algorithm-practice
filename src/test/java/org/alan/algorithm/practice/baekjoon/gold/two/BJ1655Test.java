package org.alan.algorithm.practice.baekjoon.gold.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1655Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7
                        1
                        5
                        2
                        10
                        -99
                        7
                        5""", """
                        1
                        1
                        2
                        2
                        2
                        2
                        5""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1655().solve(input));
    }
}

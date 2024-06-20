package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1922Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6
                        9
                        1 2 5
                        1 3 4
                        2 3 2
                        2 4 7
                        3 4 6
                        3 5 11
                        4 5 3
                        4 6 8
                        5 6 8""", "23")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1922().solve(input));
    }
}

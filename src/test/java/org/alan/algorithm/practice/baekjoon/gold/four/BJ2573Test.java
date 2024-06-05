package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2573Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 7
                        0 0 0 0 0 0 0
                        0 2 4 5 3 0 0
                        0 3 0 2 5 2 0
                        0 7 6 2 4 0 0
                        0 0 0 0 0 0 0""", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2573().solve(input));
    }
}

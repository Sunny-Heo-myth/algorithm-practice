package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3190Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6
                        3
                        3 4
                        2 5
                        5 3
                        3
                        3 D
                        15 L
                        17 D""", "9"),
                Arguments.of("""
                        10
                        4
                        1 2
                        1 3
                        1 4
                        1 5
                        4
                        8 D
                        10 D
                        11 D
                        13 L""", "21"),
                Arguments.of("""
                        10
                        5
                        1 5
                        1 3
                        1 2
                        1 6
                        1 7
                        4
                        8 D
                        10 D
                        11 D
                        13 L""", "13")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3190().solve(input));
    }
}

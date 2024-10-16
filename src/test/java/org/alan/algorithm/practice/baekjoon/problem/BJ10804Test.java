package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10804Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 10
                        9 13
                        1 2
                        3 4
                        5 6
                        1 2
                        3 4
                        5 6
                        1 20
                        1 20""", "1 2 3 4 10 9 8 7 13 12 11 5 6 14 15 16 17 18 19 20"),
                Arguments.of("""
                        1 1
                        2 2
                        3 3
                        4 4
                        5 5
                        6 6
                        7 7
                        8 8
                        9 9
                        10 10""", "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20"),
                Arguments.of("""
                        1 20
                        2 19
                        3 18
                        4 17
                        5 16
                        6 15
                        7 14
                        8 13
                        9 12
                        10 11""", "20 2 18 4 16 6 14 8 12 10 11 9 13 7 15 5 17 3 19 1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10804().solve(input));
    }
}

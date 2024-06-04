package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17404Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3
                        26 40 83
                        49 60 57
                        13 89 99""", "110"),
                Arguments.of("""
                        3
                        1 100 100
                        100 1 100
                        100 100 1""", "3"),
                Arguments.of("""
                        3
                        1 100 100
                        100 100 100
                        1 100 100""", "201"),
                Arguments.of("""
                        6
                        30 19 5
                        64 77 64
                        15 19 97
                        4 71 57
                        90 86 84
                        93 32 91""", "208"),
                Arguments.of("""
                        8
                        71 39 44
                        32 83 55
                        51 37 63
                        89 29 100
                        83 58 11
                        65 13 15
                        47 25 29
                        60 66 19""", "253")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17404().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11052Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        1 5 6 7""", "10"),
                Arguments.of("""
                        5
                        10 9 8 7 6""", "50"),
                Arguments.of("""
                        10
                        1 1 2 3 5 8 13 21 34 55""", "55"),
                Arguments.of("""
                        10
                        5 10 11 12 13 30 35 40 45 47""", "50"),
                Arguments.of("""
                        4
                        5 2 8 10""", "20"),
                Arguments.of("""
                        4
                        3 5 15 16""", "18")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11052(input).solve());
    }
}

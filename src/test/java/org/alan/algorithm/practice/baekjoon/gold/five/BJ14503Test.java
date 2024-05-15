package org.alan.algorithm.practice.baekjoon.gold.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ14503Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 3
                        1 1 0
                        1 1 1
                        1 0 1
                        1 1 1""", "1"),
                Arguments.of("""
                        5 5
                        1 1 0
                        1 1 1 1 1
                        1 0 0 0 1
                        1 0 0 0 1
                        1 0 0 0 1
                        1 1 1 1 1""", "9"),
                Arguments.of("""
                        11 10
                        7 4 0
                        1 1 1 1 1 1 1 1 1 1
                        1 0 0 0 0 0 0 0 0 1
                        1 0 0 0 1 1 1 1 0 1
                        1 0 0 1 1 0 0 0 0 1
                        1 0 1 1 0 0 0 0 0 1
                        1 0 0 0 0 0 0 0 0 1
                        1 0 0 0 0 0 0 1 0 1
                        1 0 0 0 0 0 1 1 0 1
                        1 0 0 0 0 0 1 1 0 1
                        1 0 0 0 0 0 0 0 0 1
                        1 1 1 1 1 1 1 1 1 1""", "57")
//                , Arguments.of("""
//                        """, "")
//                , Arguments.of("""
//                        """, "")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ14503().solve(input));
    }
}

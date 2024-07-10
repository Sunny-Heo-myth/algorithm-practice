package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1027Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        15
                        1 5 3 2 6 3 2 6 4 2 5 7 3 1 5""", "7"),
                Arguments.of("""
                        1
                        10""", "0"),
                Arguments.of("""
                        4
                        5 5 5 5""", "2"),
                Arguments.of("""
                        5
                        1 2 7 3 2""", "4"),
                Arguments.of("""
                        10
                        1000000000 999999999 999999998 999999997 999999996 1 2 3 4 5""", "6")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1027().solve(input));
    }
}

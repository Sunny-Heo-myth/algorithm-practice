package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13335Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 2 10
                        7 4 5 6""", "8"),
                Arguments.of("""
                        1 100 100
                        10""", "101"),
                Arguments.of("""
                        10 100 100
                        10 10 10 10 10 10 10 10 10 10""", "110"),
                Arguments.of("""
                        10 5 20
                        2 2 2 2 2 2 2 2 2 2""", "15"),
                Arguments.of("""
                        6 5 5
                        2 2 2 2 2 2""", "17")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ13335().solve(input));
    }
}

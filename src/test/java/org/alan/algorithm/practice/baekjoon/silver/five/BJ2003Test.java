package org.alan.algorithm.practice.baekjoon.silver.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2003Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 2
                        1 1 1 1""", "3"),
                Arguments.of("""
                        10 5
                        1 2 3 4 2 5 3 1 1 2""", "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2003().solve(input));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2003().solve2(input));
    }
}

package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2531Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        8 30 4 30
                        7
                        9
                        7
                        30
                        2
                        7
                        9
                        25""", "5"),
                Arguments.of("""
                        8 50 4 7
                        2
                        7
                        9
                        25
                        7
                        9
                        7
                        30""", "4"),
                Arguments.of("""
                        3 50 2 1
                        1
                        2
                        3""", "3"),
                Arguments.of("""
                        10 10 2 7
                        6
                        7
                        6
                        7
                        6
                        7
                        6
                        7
                        6
                        1""", "3"),
                Arguments.of("""
                        10 10 5 7
                        6
                        7
                        6
                        7
                        6
                        1
                        2
                        7
                        6
                        7""", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2531().solve(input));
    }
}

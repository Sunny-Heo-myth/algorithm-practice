package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2457Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        1 1 5 31
                        1 1 6 30
                        5 15 8 31
                        6 10 12 10""", "2"),
                Arguments.of("""
                        10
                        2 15 3 23
                        4 12 6 5
                        5 2 5 31
                        9 14 12 24
                        6 15 9 3
                        6 3 6 15
                        2 28 4 25
                        6 15 9 27
                        10 5 12 31
                        7 14 9 1""", "5")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2457().solve(input));
    }
}

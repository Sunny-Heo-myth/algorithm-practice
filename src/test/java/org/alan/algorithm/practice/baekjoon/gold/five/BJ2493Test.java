package org.alan.algorithm.practice.baekjoon.gold.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2493Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        6 9 5 7 4""", "0 0 2 2 4"),
                Arguments.of("""
                        8
                        3 7 4 2 1 8 10 9""", "0 0 2 3 4 0 0 7"),
                Arguments.of("""
                        10
                        7 5 1 9 6 4 8 2 10 3""", "0 1 2 0 4 5 4 7 0 9")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2493().solve(input));
    }
}

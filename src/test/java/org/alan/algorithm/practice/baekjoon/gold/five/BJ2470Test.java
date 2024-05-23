package org.alan.algorithm.practice.baekjoon.gold.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2470Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        -2 4 -99 -1 98""", "-99 98"),
                Arguments.of("""
                        2
                        -2 -99""", "-99 -2"),
                Arguments.of("""
                        2
                        -2 -99 -1111""", "-99 -2"),
                Arguments.of("""
                        5
                        -20 0 3 20 -99""", "-20 20")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2470().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2467Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        -99 -2 -1 4 98""", "-99 98"),
                Arguments.of("""
                        4
                        -100 -2 -1 103""", "-2 -1"),
                Arguments.of("""
                        10
                        -100 -80 -40 -30 -1 0 12 33 56 84 123""", "-1 0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2467().solve(input));
    }

}

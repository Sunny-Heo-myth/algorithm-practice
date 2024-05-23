package org.alan.algorithm.practice.baekjoon.gold.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1068Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        -1 0 0 1 1
                        2""", "2"),
                Arguments.of("""
                        5
                        -1 0 1 2 3
                        3""", "1"),
                Arguments.of("""
                        5
                        -1 0 1 2 3
                        2""", "1"),
                Arguments.of("""
                        5
                        -1 0 1 2 3
                        1""", "1"),
                Arguments.of("""
                        5
                        -1 0 0 1 1
                        1""", "1"),
                Arguments.of("""
                        5
                        -1 0 0 1 1
                        0""", "0"),
                Arguments.of("""
                        9
                        -1 0 0 2 2 4 4 6 6
                        4""", "2"),
                Arguments.of("""
                        10
                        1 -1 1 2 2 4 4 6 6 6
                        6""", "3"),
                Arguments.of("""
                        2
                        -1 0
                        1""", "1"),
                Arguments.of("""
                        3
                        -1 0 0
                        1""", "1"),
                Arguments.of("""
                        3
                        2 2 -1
                        1""", "1"),
                Arguments.of("""
                        1
                        -1
                        0""", "0"),
                Arguments.of("""
                        10
                        5 5 5 5 5 -1 1 6 6 6
                        1""", "4"),
                Arguments.of("""
                        10
                        5 5 5 5 5 -1 1 6 6 6
                        0""", "6")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1068().solve(input));
    }
    
}

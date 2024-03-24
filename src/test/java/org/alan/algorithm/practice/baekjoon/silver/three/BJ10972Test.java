package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10972Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        1 2 3 4""", "1 2 4 3"),
                Arguments.of("""
                        5
                        5 4 3 2 1""", "-1"),
                Arguments.of("""
                        6
                        6 5 4 1 3 2""", "6 5 4 2 1 3"),
                Arguments.of("""
                        6
                        4 5 6 3 2 1""", "4 6 1 2 3 5"),
                Arguments.of("""
                        1
                        1""", "-1"),
                Arguments.of("""
                        6
                        1 2 3 6 5 4""", "1 2 4 3 5 6"),
                Arguments.of("""
                        6
                        1 3 2 6 5 4""", "1 3 4 2 5 6"),
                Arguments.of("""
                        6
                        4 6 5 3 2 1""", "5 1 2 3 4 6"),
                Arguments.of("""
                        10
                        1 2 3 4 5 6 7 8 9 10""", "1 2 3 4 5 6 7 8 10 9"),
                Arguments.of("""
                        10
                        4 6 7 8 9 10 5 3 2 1""", "4 6 7 8 10 1 2 3 5 9"),
                Arguments.of("""
                        10
                        4 6 7 8 9 5 3 2 1 10""", "4 6 7 8 9 5 3 2 10 1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10972().solve(input));
    }

}

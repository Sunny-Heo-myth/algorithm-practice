package org.alan.algorithm.practice.baekjoon.tagged.bt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ19236Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        7 6 2 3 15 6 9 8
                        3 1 1 8 14 7 10 1
                        6 1 13 6 4 3 11 4
                        16 1 8 7 5 2 12 2""", "33"),
                Arguments.of("""
                        16 7 1 4 4 3 12 8
                        14 7 7 6 3 4 10 2
                        5 2 15 2 8 3 6 4
                        11 8 2 4 13 5 9 4""", "43"),
                Arguments.of("""
                        12 6 14 5 4 5 6 7
                        15 1 11 7 3 7 7 5
                        10 3 8 3 16 6 1 1
                        5 8 2 7 13 6 9 2""", "76"),
                Arguments.of("""
                        2 6 10 8 6 7 9 4
                        1 7 16 6 4 2 5 8
                        3 7 8 6 7 6 14 8
                        12 7 15 4 11 3 13 3""", "39"),
                Arguments.of("""
                        7 1 2 6 15 7 9 3
                        3 5 1 4 14 1 10 6
                        6 4 13 3 4 6 11 1
                        16 5 8 7 5 2 12 2""", "7"),
                Arguments.of("""
                        7 6 2 6 15 7 9 3
                        3 5 1 4 14 1 10 6
                        6 4 13 3 4 6 11 1
                        16 5 8 7 5 2 12 2""", "88"),
                Arguments.of("""
                        7 6 2 1 15 1 9 1
                        3 1 1 1 14 7 10 3
                        6 1 13 6 4 3 11 4
                        16 3 8 7 5 2 12 2""", "42"),
                Arguments.of("""
                        12 6 14 5 4 5 6 7
                        15 1 11 3 3 7 7 5
                        10 3 8 2 16 6 1 1
                        5 8 2 7 13 6 9 4""", "55")
        );
    }
    
    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ19236().solve(input));
    }

}

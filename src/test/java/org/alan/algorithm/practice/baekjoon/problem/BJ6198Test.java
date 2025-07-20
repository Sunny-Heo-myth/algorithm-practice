package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BJ6198Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6
                        10
                        3
                        7
                        4
                        12
                        2""", "5"),
                Arguments.of("""
                        6
                        1
                        1
                        1
                        1
                        1
                        1""", "0"),
                Arguments.of("""
                        6
                        1
                        2
                        1
                        2
                        1
                        2""", "2"),
                Arguments.of("""
                        6
                        2
                        1
                        2
                        1
                        2
                        1""", "3"),
                Arguments.of("""
                        1
                        100""", "0"),
                Arguments.of("""
                        6
                        6
                        5
                        4
                        3
                        2
                        1""", "15"),
                Arguments.of("""
                        1
                        1""", "0"),
                Arguments.of("""
                        5
                        1
                        2
                        3
                        4
                        5""", "0"),
                Arguments.of("""
                        5
                        5
                        5
                        5
                        2
                        1""", "3"),
                Arguments.of("""
                        7
                        10
                        2
                        9
                        2
                        8
                        2
                        7""", "12"),
                Arguments.of("""
                        8
                        2
                        10
                        2
                        9
                        2
                        8
                        2
                        7""", "12")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ6198().solve(input));
    }

}

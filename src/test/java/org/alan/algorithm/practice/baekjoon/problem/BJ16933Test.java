package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16933Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 4 1
                        0010""", "5"),
                Arguments.of("""
                        1 4 1
                        0100""", "4"),
                Arguments.of("""
                        1 1 1
                        0""", "1"),
                Arguments.of("""
                        2 2 1
                        00
                        00""", "3"),
                Arguments.of("""
                        2 2 1
                        01
                        10""", "3"),
                Arguments.of("""
                        2 2 0
                        01
                        10""", "-1"),
                Arguments.of("""
                        3 3 0
                        011
                        101
                        110""", "-1"),
                Arguments.of("""
                        3 3 1
                        011
                        101
                        110""", "-1"),
                Arguments.of("""
                        3 3 2
                        011
                        101
                        110""", "5"),
                Arguments.of("""
                        4 4 2
                        0011
                        1101
                        1110""", "7"),
                Arguments.of("""
                        4 4 3
                        0111
                        1111
                        1111
                        1110""", "-1"),
                Arguments.of("""
                        6 4 1
                        0100
                        1110
                        1000
                        0000
                        0111
                        0000""", "15"),
                Arguments.of("""
                        6 4 2
                        0100
                        1110
                        1000
                        0000
                        0111
                        0000""", "9"),
                Arguments.of("""
                        7 4 2
                        0100
                        1110
                        1000
                        0000
                        0000
                        0111
                        0000""", "11")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16933().solve(input));
    }
}

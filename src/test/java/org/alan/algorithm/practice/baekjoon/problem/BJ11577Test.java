package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11577Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6 3
                        1 1 0 0 0 1""", "3"),
                Arguments.of("""
                        6 3
                        1 1 0 0 1 1""", "Insomnia"),
                Arguments.of("""
                        6 3
                        1 1 1 0 0 0""", "1"),
                Arguments.of("""
                        3 2
                        1 1 1""", "Insomnia"),
                Arguments.of("""
                        4 2
                        1 0 1 0""", "2"),
                Arguments.of("""
                        6 3
                        0 1 1 0 1 1""", "2"),
                Arguments.of("""
                        6 3
                        1 1 0 0 0 0""", "Insomnia")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11577().solve(input));
    }
}

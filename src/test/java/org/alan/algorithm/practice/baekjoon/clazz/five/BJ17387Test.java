package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17387Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 1 5 5
                        1 5 5 1""", "1"),
                Arguments.of("""
                        1 1 5 5
                        6 10 10 6""", "0"),
                Arguments.of("""
                        1 1 5 5
                        5 5 1 1""", "1"),
                Arguments.of("""
                        1 1 5 5
                        3 3 5 5""", "1"),
                Arguments.of("""
                        1 1 5 5
                        3 3 1 3""", "1"),
                Arguments.of("""
                        1 1 5 5
                        5 5 9 9""", "1"),
                Arguments.of("""
                        1 1 5 5
                        6 6 9 9""", "0"),
                Arguments.of("""
                        1 1 5 5
                        5 5 1 5""", "1"),
                Arguments.of("""
                        1 1 5 5
                        6 6 1 5""", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17387().solve(input));
    }
}

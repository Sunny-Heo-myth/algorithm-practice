package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1799Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        1""", "1"),
                Arguments.of("""
                        1
                        0""", "0"),
                Arguments.of("""
                        3
                        1 1 0
                        0 1 0
                        1 0 1""", "3"),
                Arguments.of("""
                        3
                        1 1 1
                        0 1 0
                        1 1 1""", "4"),
                Arguments.of("""
                        5
                        1 1 0 1 1
                        0 1 0 0 0
                        1 0 1 0 1
                        1 0 0 0 0
                        1 0 1 1 1""", "7")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1799().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2146Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        10
                        1 1 1 0 0 0 0 1 1 1
                        1 1 1 1 0 0 0 0 1 1
                        1 0 1 1 0 0 0 0 1 1
                        0 0 1 1 1 0 0 0 0 1
                        0 0 0 1 0 0 0 0 0 1
                        0 0 0 0 0 0 0 0 0 1
                        0 0 0 0 0 0 0 0 0 0
                        0 0 0 0 1 1 0 0 0 0
                        0 0 0 0 1 1 1 0 0 0
                        0 0 0 0 0 0 0 0 0 0""", "3"),
                Arguments.of("""
                        2
                        1 0
                        0 1""", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2146().solve(input));
    }
}

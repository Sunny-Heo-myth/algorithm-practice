package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2503Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        123 1 1
                        356 1 0
                        327 2 0
                        489 0 1""", "2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2503().solve(input));
    }
}

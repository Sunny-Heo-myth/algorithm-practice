package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1449Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 2
                        1 2 100 101""", "2"),
                Arguments.of("""
                        4 3
                        1 2 3 4""", "2"),
                Arguments.of("""
                        3 1
                        3 2 1""", "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1449().solve(input));
    }
}

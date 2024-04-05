package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10973Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        1 2 3 4""", "-1"),
                Arguments.of("""
                        5
                        5 4 3 2 1""", "5 4 3 1 2"),
                Arguments.of("""
                        5
                        1 2 5 3 4""", "1 2 4 5 3"),
                Arguments.of("""
                        5
                        1 2 3 4 5""", "-1"),
                Arguments.of("""
                        6
                        1 2 5 3 4 6""", "1 2 4 6 5 3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10973().solve(input));
    }
}

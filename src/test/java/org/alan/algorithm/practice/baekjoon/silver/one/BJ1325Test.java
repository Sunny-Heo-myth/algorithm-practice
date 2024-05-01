package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1325Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 4
                        3 1
                        3 2
                        4 3
                        5 3""", "1 2"),
                Arguments.of("""
                        10 9
                        1 10
                        1 9
                        1 8
                        1 7
                        1 6
                        1 5
                        1 4
                        1 3
                        1 2""", "2 3 4 5 6 7 8 9 10"),
                Arguments.of("""
                        10 9
                        2 1
                        3 1
                        4 1
                        5 1
                        6 1
                        7 1
                        8 1
                        9 1
                        10 1""", "1"),
                Arguments.of("""
                        10 8
                        2 1
                        3 1
                        4 1
                        5 1
                        7 6
                        8 6
                        9 6
                        10 6""", "1 6")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1325().solve(input));
    }
}

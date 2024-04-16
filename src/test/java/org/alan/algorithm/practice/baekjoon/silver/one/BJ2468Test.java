package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2468Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        6 8 2 6 2
                        3 2 3 4 6
                        6 7 3 3 2
                        7 2 5 3 6
                        8 9 5 2 7""", "5"),
                Arguments.of("""
                        7
                        9 9 9 9 9 9 9
                        9 2 1 2 1 2 9
                        9 1 8 7 8 1 9
                        9 2 7 9 7 2 9
                        9 1 8 7 8 1 9
                        9 2 1 2 1 2 9
                        9 9 9 9 9 9 9""", "6")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2468().solve(input));
    }
}

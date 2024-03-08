package org.alan.algorithm.practice.baekjoon.silver.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11004Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 2
                        4 1 2 3 5""", "2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11004().solve(input));
    }
}

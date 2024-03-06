package org.alan.algorithm.practice.baekjoon.silver.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1476Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 16 16", "16"),
                Arguments.of("1 1 1", "1"),
                Arguments.of("1 2 3", "5266"),
                Arguments.of("15 28 19", "7980")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1476().solve(input));
    }
}

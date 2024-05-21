package org.alan.algorithm.practice.baekjoon.gold.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2225Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("20 2", "21"),
                Arguments.of("6 4", "84")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2225().solve(input));
    }
}

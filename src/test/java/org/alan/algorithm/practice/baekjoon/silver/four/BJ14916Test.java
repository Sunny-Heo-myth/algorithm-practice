package org.alan.algorithm.practice.baekjoon.silver.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ14916Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("13", "5"),
                Arguments.of("14", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ14916().solve(input));
    }
}

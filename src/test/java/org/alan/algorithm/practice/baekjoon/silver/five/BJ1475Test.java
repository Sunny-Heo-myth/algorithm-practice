package org.alan.algorithm.practice.baekjoon.silver.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1475Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("9999", "2"),
                Arguments.of("122", "2"),
                Arguments.of("12635", "1"),
                Arguments.of("888888", "6")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1475().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.silver.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1094Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("23", "4"),
                Arguments.of("32", "1"),
                Arguments.of("64", "1"),
                Arguments.of("48", "2")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1094().solve(input));
    }
}

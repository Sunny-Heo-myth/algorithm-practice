package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ6588Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("8", "8 = 3 + 5"),
                Arguments.of("20", "20 = 3 + 17"),
                Arguments.of("42", "42 = 5 + 37")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ6588().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9657Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "SK"),
                Arguments.of("2", "CY"),
                Arguments.of("3", "SK"),
                Arguments.of("4", "SK"),
                Arguments.of("7", "CY"),
                Arguments.of("6", "SK"),
                Arguments.of("5", "SK")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9657().solve(input));
    }
}

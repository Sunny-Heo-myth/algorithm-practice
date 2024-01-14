package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1016Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 10", "7"),
                Arguments.of("15 15", "1"),
                Arguments.of("1 1000", "608")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1016().solve(input));
    }
}

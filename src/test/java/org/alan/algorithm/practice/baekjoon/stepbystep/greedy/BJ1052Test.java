package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1052Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 1", "1"),
                Arguments.of("13 2", "3"),
                Arguments.of("1000000 5", "15808")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1052().solve(input));
    }
}

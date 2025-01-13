package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ12781Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("0 0 6 2 5 -4 2 2", "1"),
                Arguments.of("-1 -5 6 3 1 10 -4 -1", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ12781().solve(input));
    }
}

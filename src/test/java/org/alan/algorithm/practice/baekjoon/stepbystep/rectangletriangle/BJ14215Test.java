package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ14215Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 2 3", "5"),
                Arguments.of("2 2 2", "6"),
                Arguments.of("1 100 1", "3"),
                Arguments.of("41 64 16", "113")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ14215 instance = new BJ14215();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}

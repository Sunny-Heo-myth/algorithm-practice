package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletrianglestep;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BJ15894Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "4"),
                Arguments.of("3", "12")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solve(String input, String expected) {
        BJ15894 instance = new BJ15894();
        assertEquals(expected, instance.solve(input));
    }
}
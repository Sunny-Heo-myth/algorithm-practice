package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2240Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7 2
                        2
                        1
                        1
                        2
                        2
                        1
                        1""", "6")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2240().solve(input));
    }
}

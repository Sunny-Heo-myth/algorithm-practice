package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1069Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("6 8 5 3", "6.0"),
                Arguments.of("3 4 6 3", "4.0"),
                Arguments.of("318 445 1200 800", "546.9451526432975"),
                Arguments.of("400 300 150 10", "40.0"),
                Arguments.of("6 8 3 2", "7.0"),
                Arguments.of("10 10 1000 5", "10.0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1069().solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2527Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 10 50 60 100 100 200 300", "d"),
                Arguments.of("45 50 600 600 400 450 500 543", "a"),
                Arguments.of("11 120 120 230 50 40 60 440", "a"),
                Arguments.of("35 56 67 90 67 80 500 600", "b"),
                Arguments.of("1 1 2 2 2 2 3 3", "c"),
                Arguments.of("2 2 3 3 1 1 2 2", "c")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2527().solve(input));
    }
}

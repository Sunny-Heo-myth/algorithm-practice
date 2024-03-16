package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1021Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        10 3
                        1 2 3""", "0"),
                Arguments.of("""
                        10 3
                        2 9 5""", "8"),
                Arguments.of("""
                        32 6
                        27 16 30 11 6 23""", "59"),
                Arguments.of("""
                        10 10
                        1 6 3 2 7 9 8 4 10 5""", "14")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1021().solve(input));
    }
}

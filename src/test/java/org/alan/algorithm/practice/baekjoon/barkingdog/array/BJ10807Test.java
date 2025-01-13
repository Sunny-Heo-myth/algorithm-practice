package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10807Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        11
                        1 4 1 2 4 2 4 2 3 4 4
                        2""", "3"),
                Arguments.of("""
                        11
                        1 4 1 2 4 2 4 2 3 4 4
                        5""", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10807().solve(input));
    }
}

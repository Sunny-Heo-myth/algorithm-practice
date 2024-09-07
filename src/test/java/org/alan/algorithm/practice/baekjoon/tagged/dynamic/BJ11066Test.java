package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11066Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        40 30 30 50""", "300"),
                Arguments.of("""
                        15
                        1 21 3 4 5 35 5 4 3 5 98 21 14 17 32""", "864")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11066().solve(input));
    }
}

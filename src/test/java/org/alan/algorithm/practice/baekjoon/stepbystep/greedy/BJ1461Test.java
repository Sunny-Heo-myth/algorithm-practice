package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1461Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7 2
                        -37 2 -6 -39 -29 11 -28""", "131"),
                Arguments.of("""
                        8 3
                        -18 -9 -4 50 22 -26 40 -45""", "158"),
                Arguments.of("""
                        6 2
                        3 4 5 6 11 -1""", "29"),
                Arguments.of("""
                        1 50
                        1""", "1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1461().solve(input));
    }
}

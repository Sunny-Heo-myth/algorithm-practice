package org.alan.algorithm.practice.baekjoon.gold.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ20040Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6 5
                        0 1
                        1 2
                        2 3
                        5 4
                        0 4""", "0"),
                Arguments.of("""
                        6 5
                        0 1
                        1 2
                        1 3
                        0 3
                        4 5""", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ20040().solve(input));
    }
}

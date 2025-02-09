package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10217Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        3 100 3
                        1 2 1 1
                        2 3 1 1
                        1 3 3 30""", "2"),
                Arguments.of("""
                        1
                        4 10 4
                        1 2 5 3
                        2 3 5 4
                        3 4 1 5
                        1 3 10 6""", "Poor KCM")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10217().solve(input));
    }
}

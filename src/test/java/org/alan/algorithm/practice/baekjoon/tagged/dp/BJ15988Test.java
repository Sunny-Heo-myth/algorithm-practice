package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15988Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "1"),
                Arguments.of("2", "2"),
                Arguments.of("3", "4"),
                Arguments.of("4", "7"),
                Arguments.of("7", "44"),
                Arguments.of("10", "274")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15988(input).solve());
    }
}

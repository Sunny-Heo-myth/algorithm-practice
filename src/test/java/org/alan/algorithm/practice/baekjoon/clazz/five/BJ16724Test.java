package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16724Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 4
                        DLLL
                        DRLU
                        RRRU""", "2"),
                Arguments.of("""
                        4 4
                        DLLL
                        DRLU
                        RRRU
                        RRRU""", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16724().solve(input));
    }
}

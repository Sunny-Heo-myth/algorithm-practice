package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1197Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3 3
                        1 2 1
                        2 3 2
                        1 3 3""", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1197().solve(input));
    }
}

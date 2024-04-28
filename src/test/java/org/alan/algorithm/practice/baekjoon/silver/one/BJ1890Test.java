package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1890Test {

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        2 3 3 1
                        1 2 1 3
                        1 2 3 1
                        3 1 1 0""", "3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1890().solve(input));
    }
}

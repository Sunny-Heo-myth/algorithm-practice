package org.alan.algorithm.practice.baekjoon.bronze.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1225Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("123 45", "54")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1225().solve(input));
    }
}

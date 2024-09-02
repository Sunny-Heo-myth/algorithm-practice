package org.alan.algorithm.practice.baekjoon.bronze.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2752Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 1 2", "1 2 3")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2752().solve(input));
    }
}

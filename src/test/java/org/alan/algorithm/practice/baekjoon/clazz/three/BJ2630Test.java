package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2630Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("8\n" +
                        "1 1 0 0 0 0 1 1\n" +
                        "1 1 0 0 0 0 1 1\n" +
                        "0 0 0 0 1 1 0 0\n" +
                        "0 0 0 0 1 1 0 0\n" +
                        "1 0 0 0 1 1 1 1\n" +
                        "0 1 0 0 1 1 1 1\n" +
                        "0 0 1 1 1 1 1 1\n" +
                        "0 0 1 1 1 1 1 1", "9\n" +
                        "7")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2630 instance = new BJ2630();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}

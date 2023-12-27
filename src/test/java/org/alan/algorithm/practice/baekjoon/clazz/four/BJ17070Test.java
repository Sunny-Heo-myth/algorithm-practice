package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17070Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3\n" +
                        "0 0 0\n" +
                        "0 0 0\n" +
                        "0 0 0", "1"),
                Arguments.of("4\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0", "3"),
                Arguments.of("5\n" +
                        "0 0 1 0 0\n" +
                        "0 0 0 0 0\n" +
                        "0 0 0 0 0\n" +
                        "0 0 0 0 0\n" +
                        "0 0 0 0 0", "0"),
                Arguments.of("6\n" +
                        "0 0 0 0 0 0\n" +
                        "0 1 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0", "13")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ17070().solve(input));
    }
}

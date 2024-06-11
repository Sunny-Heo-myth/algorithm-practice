package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ30802Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        23
                        3 1 4 1 5 9
                        5 7""", """
                        7
                        3 2""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ30802().solve(input));
    }
}

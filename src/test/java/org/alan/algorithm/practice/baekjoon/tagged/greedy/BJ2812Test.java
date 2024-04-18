package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.alan.algorithm.practice.baekjoon.clazz.five.BJ2812;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2812Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 2
                        1924""", "94"),
                Arguments.of("""
                        7 3
                        1231234""", "3234"),
                Arguments.of("""
                        10 4
                        4177252841""", "775841")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2812().solve(input));
    }
}

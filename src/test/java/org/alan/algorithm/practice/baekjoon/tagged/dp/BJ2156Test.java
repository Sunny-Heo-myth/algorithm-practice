package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ2156Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        6
                        6
                        10
                        13
                        9
                        8
                        1""", "33")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2156(input).solve());
    }

}
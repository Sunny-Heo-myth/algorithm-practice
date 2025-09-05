package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ2295Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        5
                        2
                        3
                        5
                        10
                        18""", "18"),
                Arguments.of("""
                        5
                        1
                        2
                        3
                        7
                        21""", "21"),
                Arguments.of("""
                        6
                        1
                        2
                        3
                        4
                        11
                        20""", "11")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2295(input).solve());
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test2(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2295_2(input).solve());
    }

}
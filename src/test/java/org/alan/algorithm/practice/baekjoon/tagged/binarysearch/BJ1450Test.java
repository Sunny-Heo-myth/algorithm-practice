package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1450Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        2 1
                        1 1""", "3"),
                Arguments.of("""
                        1 1
                        1""", "2"),
                Arguments.of("""
                        1 2
                        1""", "2"),
                Arguments.of("""
                        2 1
                        2 2""", "1"),
                Arguments.of("""
                        2 2
                        1 1""", "4"),
                Arguments.of("""
                        30 30
                        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1""", "1073741824")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1450(input).solve());
    }
}

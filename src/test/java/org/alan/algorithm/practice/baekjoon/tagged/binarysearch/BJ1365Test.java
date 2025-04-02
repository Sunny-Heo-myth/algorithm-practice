package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1365Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("""
                        4
                        2 3 4 1""", "1"),
                Arguments.of("""
                        4
                        2 4 3 1""", "2"),
                Arguments.of("""
                        4
                        4 1 2 3""", "1"),
                Arguments.of("""
                        5
                        4 1 2 3 5""", "1"),
                Arguments.of("""
                        5
                        2 3 4 1 5""", "1"),
                Arguments.of("""
                        6
                        4 2 3 5 6 1""", "2"),
                Arguments.of("""
                        6
                        2 6 5 4 3 1""", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1365(input).solve());
    }
}

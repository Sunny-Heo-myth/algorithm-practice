package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ31858Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        1""", "0"),
                Arguments.of("""
                        2
                        1 2""", "1"),
                Arguments.of("""
                        2
                        2 1""", "1"),
                Arguments.of("""
                        3
                        1 2 3""", "2"),
                Arguments.of("""
                        3
                        2 1 3""", "3"),
                Arguments.of("""
                        4
                        3 2 1 4""", "5"),
                Arguments.of("""
                        5
                        1 2 3 4 5""", "4"),
                Arguments.of("""
                        5
                        5 4 3 2 1""", "4"),
                Arguments.of("""
                        5
                        1 3 2 4 5""", "5"),
                Arguments.of("""
                        5
                        1 3 5 4 2""", "4"),
                Arguments.of("""
                        5
                        1 4 5 2 3""", "5"),
                Arguments.of("""
                        5
                        5 3 1 2 4""", "7"),
                Arguments.of("""
                        5
                        4 2 3 1 5""", "7"),
                Arguments.of("""
                        5
                        3 2 1 4 5""", "6")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ31858(input).solve());
    }

}

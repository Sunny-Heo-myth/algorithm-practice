package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2482Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4
                        1""", "4"),
                Arguments.of("""
                        4
                        2""", "2"),
                Arguments.of("""
                        4
                        3""", "0"),
                Arguments.of("""
                        5
                        1""", "5"),
                Arguments.of("""
                        5
                        2""", "5"),
                Arguments.of("""
                        5
                        3""", "0"),
                Arguments.of("""
                        8
                        4""", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2482().solve(input));
    }

}

package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10093Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        8 14""", """
                        5
                        9 10 11 12 13"""),
                Arguments.of("""
                        14 8""", """
                        5
                        9 10 11 12 13"""),
                Arguments.of("""
                        8 9""", """
                        0"""),
                Arguments.of("""
                        9 9""", """
                        0""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10093().solve(input));
    }
}

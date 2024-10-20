package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1919Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        aabbcc
                        xxyybb""", "8"),
                Arguments.of("""
                        aabbbc
                        xxybbb""", "6"),
                Arguments.of("""
                        a
                        x""", "2"),
                Arguments.of("""
                        a
                        a""", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1919().solve(input));
    }
}

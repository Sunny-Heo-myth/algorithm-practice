package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1414Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        3
                        abc
                        def
                        ghi""", "40"),
                Arguments.of("""
                        2
                        a0
                        0b""", "-1"),
                Arguments.of("""
                        4
                        0X00
                        00Y0
                        0000
                        00Z0""", "0"),
                Arguments.of("""
                        2
                        Az
                        aZ""", "105"),
                Arguments.of("""
                        4
                        0top
                        c0od
                        er0o
                        pen0""", "134")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1414().solve(input));
    }
}

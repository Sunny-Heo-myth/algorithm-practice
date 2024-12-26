package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ20304Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        0
                        1
                        0""", "0"),
                Arguments.of("""
                        1
                        1
                        0""", "1"),
                Arguments.of("""
                        1
                        2
                        0 1""", "0"),
                Arguments.of("""
                        2
                        2
                        0 1""", "1"),
                Arguments.of("""
                        10
                        1
                        1""", "3"),
                Arguments.of("""
                        10
                        1
                        7""", "4"),
                Arguments.of("""
                        10
                        2
                        7 8""", "2"),
                Arguments.of("""
                        10
                        2
                        3 4""", "2"),
                Arguments.of("""
                        10
                        3
                        3 4 5""", "2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ20304().solve(input));
    }
}

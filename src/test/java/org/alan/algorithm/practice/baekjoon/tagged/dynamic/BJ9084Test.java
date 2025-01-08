package org.alan.algorithm.practice.baekjoon.tagged.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9084Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        1
                        1""", "1"),
                Arguments.of("""
                        1
                        1
                        5""", "1"),
                Arguments.of("""
                        1
                        2
                        1""", "0"),
                Arguments.of("""
                        1
                        2
                        5""", "0"),
                Arguments.of("""
                        2
                        1 2
                        1000""", "501"),
                Arguments.of("""
                        2
                        5 7
                        22""", "1"),
                Arguments.of("""
                        3
                        1 5 10
                        100""", "121")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ9084().solve(input));
    }
}

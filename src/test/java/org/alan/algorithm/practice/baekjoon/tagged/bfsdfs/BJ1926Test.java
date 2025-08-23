package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1926Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6 5
                        1 1 0 1 1
                        0 1 1 0 0
                        0 0 0 0 0
                        1 0 1 1 1
                        0 0 1 1 1
                        0 0 1 1 1""", """
                        4
                        9"""),
                Arguments.of("""
                        6 6
                        1 1 0 1 1
                        0 1 1 0 0
                        0 1 1 0 0
                        1 0 1 1 1
                        0 0 1 1 1
                        1 0 1 1 1""", """
                        4
                        15""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1926(input).solve());
    }
}

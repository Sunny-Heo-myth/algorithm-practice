package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1516Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1
                        10 -1""", """
                        10"""),
                Arguments.of("""
                        3
                        10 -1
                        10 1 -1
                        5 1 -1""", """
                        10
                        20
                        15"""),
                Arguments.of("""
                        5
                        10 -1
                        10 1 -1
                        4 1 -1
                        4 3 1 -1
                        3 3 -1""", """
                        10
                        20
                        14
                        18
                        17""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1516().solve(input));
    }
}

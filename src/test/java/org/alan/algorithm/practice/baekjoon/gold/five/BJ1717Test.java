package org.alan.algorithm.practice.baekjoon.gold.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1717Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7 8
                        0 1 3
                        1 1 7
                        0 7 6
                        1 7 1
                        0 3 7
                        0 4 2
                        0 1 1
                        1 1 1""", """
                        NO
                        NO
                        YES""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1717().solve(input));
    }
}

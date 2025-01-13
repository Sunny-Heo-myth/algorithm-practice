package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3495Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 4
                        /\\/\\
                        \\../
                        .\\.\\
                        ..\\/
                        """, "8")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3495().solve(input));
    }
}

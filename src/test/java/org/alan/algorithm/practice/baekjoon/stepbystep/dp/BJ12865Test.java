package org.alan.algorithm.practice.baekjoon.stepbystep.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ12865Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        4 7
                        6 13
                        4 8
                        3 6
                        5 12""", "14")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ12865().solve(input));
    }
}

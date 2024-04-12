package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ7795Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 3
                        8 1 7 3 1
                        3 6 1""", "7"),
                Arguments.of("""
                        3 4
                        2 13 7
                        103 11 290 215""", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ7795().solve(input));
    }
}

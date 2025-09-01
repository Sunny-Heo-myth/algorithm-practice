package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ7562Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        8
                        0 0
                        7 0""", "5"),
                Arguments.of("""
                        100
                        0 0
                        30 50""", "28"),
                Arguments.of("""
                        10
                        1 1
                        1 1""", "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ7562(input).solve());
    }
}

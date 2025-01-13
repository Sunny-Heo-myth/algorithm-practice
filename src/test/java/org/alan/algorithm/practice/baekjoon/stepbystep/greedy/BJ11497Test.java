package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11497Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        7
                        13 10 12 11 10 11 12""", "1"),
                Arguments.of("""
                        5
                        2 4 5 7 9""", "4"),
                Arguments.of("""
                        8
                        6 6 6 6 6 6 6 6""", "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11497().solve(input));
    }
}

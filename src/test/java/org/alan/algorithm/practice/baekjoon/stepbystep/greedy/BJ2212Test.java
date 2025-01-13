package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2212Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        6
                        2
                        1 6 9 3 6 7""", "5"),
                Arguments.of("""
                        10
                        5
                        20 3 14 6 7 8 18 10 12 15""", "7")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2212().solve(input));
    }
}

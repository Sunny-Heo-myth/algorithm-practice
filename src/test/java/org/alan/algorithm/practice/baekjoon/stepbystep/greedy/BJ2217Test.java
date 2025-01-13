package org.alan.algorithm.practice.baekjoon.stepbystep.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2217Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        2
                        10
                        15""", "20")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2217 instance = new BJ2217();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}

package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11758Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        1 1
                        5 5
                        7 3""", "-1"),
                Arguments.of("""
                        1 1
                        3 3
                        5 5""", "0"),
                Arguments.of("""
                        1 1
                        7 3
                        5 5""", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11758 instance = new BJ11758();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}

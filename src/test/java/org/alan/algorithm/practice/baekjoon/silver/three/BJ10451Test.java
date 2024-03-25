package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10451Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        8
                        3 2 7 8 1 4 5 6""", "3"),
                Arguments.of("""
                        10
                        2 1 3 4 5 6 7 9 10 8""", "7")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10451().solve(input));
    }
}

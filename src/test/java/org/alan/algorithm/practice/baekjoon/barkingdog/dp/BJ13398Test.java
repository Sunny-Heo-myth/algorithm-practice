package org.alan.algorithm.practice.baekjoon.barkingdog.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13398Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        10
                        10 -4 3 1 5 6 -35 12 21 -1""", "54"),
                Arguments.of("""
                        1
                        10""", "10"),
                Arguments.of("""
                        10
                        2 1 -4 3 4 -4 6 5 -5 1""", "18"),
                Arguments.of("""
                        5
                        -1 -2 -3 -4 -5""", "-1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ13398().solve(input));
    }
}

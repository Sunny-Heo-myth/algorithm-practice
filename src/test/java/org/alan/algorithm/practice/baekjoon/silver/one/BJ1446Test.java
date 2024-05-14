package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1446Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 150
                        0 50 10
                        0 50 20
                        50 100 10
                        100 151 10
                        110 140 90""", "70"),
                Arguments.of("""
                        2 100
                        10 60 40
                        50 90 20""", "80"),
                Arguments.of("""
                        8 900
                        0 10 9
                        20 60 45
                        80 190 100
                        50 70 15
                        160 180 14
                        140 160 14
                        420 901 5
                        450 900 0""", "432")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1446().solve(input));
    }
}

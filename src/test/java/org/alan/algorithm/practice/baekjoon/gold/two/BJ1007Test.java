package org.alan.algorithm.practice.baekjoon.gold.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1007Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
//                Arguments.of("""
//                        4
//                        5 5
//                        5 -5
//                        -5 5
//                        -5 -5""", "0.000000000000"),
                Arguments.of("""
                        2
                        -100000 -100000
                        100000 100000""", "282842.712474619038"),
                Arguments.of("""
                        10
                        26 -76
                        65 -83
                        78 38
                        92 22
                        -60 -42
                        -27 85
                        42 46
                        -86 98
                        92 -47
                        -41 38""", "13.341664064126334")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1007().solve(input));
    }
}
